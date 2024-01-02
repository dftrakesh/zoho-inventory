package io.zohoinventory;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zohoinventory.models.authenticationapi.AccessCredentials;
import io.zohoinventory.models.authenticationapi.AccessTokenResponse;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static io.zohoinventory.constantcode.ConstantCodes.*;

public class ZohoInventorySdk {

    protected HttpClient client;
    private ObjectMapper objectMapper;
    protected AccessCredentials accessCredential;

    public ZohoInventorySdk(AccessCredentials accessCredential) {
        client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.accessCredential = accessCredential;
    }

    @SneakyThrows
    protected <T> T getRequestWrapped(HttpRequest request, Class<T> tclass)
    {
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenComposeAsync(response -> tryResend(client, request, HttpResponse.BodyHandlers.ofString(), response, 1))
                .thenApplyAsync(HttpResponse::body)
                .thenApplyAsync(responseBody -> convertBody(responseBody, tclass))
                .get();
    }

    @SneakyThrows
    protected <T> CompletableFuture<HttpResponse<T>> tryResend(HttpClient client,
                                                               HttpRequest request,
                                                               HttpResponse.BodyHandler<T> handler,
                                                               HttpResponse<T> resp, int count) {

        if (resp.statusCode() == TOO_MANY_REQUEST_EXCEPTION_CODE && count < MAX_ATTEMPTS) {
            Thread.sleep(TIME_OUT_DURATION);
            return client.sendAsync(request, handler)
                    .thenComposeAsync(response -> tryResend(client, request, handler, response, count + 1));
        }
        return CompletableFuture.completedFuture(resp);
    }

    protected void refreshAccessToken()
    {
        if(accessCredential.getAccessToken() == null || accessCredential.getExpiresInTime() == null || LocalDateTime.now().isAfter(accessCredential.getExpiresInTime()))
        {
            HashMap<String, String> params = new HashMap<>();
            params.put(GRANT_TYPE, AUTHORIZATION_CODE);
            params.put(CLIENT_ID, accessCredential.getClientId());
            params.put(CLIENT_SECRET, accessCredential.getClientSecret());
            params.put(REFRESH_TOKEN, accessCredential.getRefreshToken());
            params.put(REDIRECT_URI, accessCredential.getRedirectUri());

            URI uriBuilder = URI.create(OAUTH_BASED_END_POINT);
            addParameters(uriBuilder, params);

            HttpRequest request = HttpRequest.newBuilder(uriBuilder)
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .header(CONTENT_TYPE, CONTENT_VALUE_APPLICATION_JSON)
                    .build();

            AccessTokenResponse accessTokenResponse = getRequestWrapped(request, AccessTokenResponse.class);
            accessCredential.setAccessToken(accessTokenResponse.getAccessToken());
            accessCredential.setExpiresInTime(LocalDateTime.now().plusSeconds(accessTokenResponse.getExpiresIn()));

        }
    }

    protected HttpRequest get(URI uri) {
        return HttpRequest.newBuilder(uri)
                .GET()
                .header(CONTENT_TYPE, CONTENT_VALUE_APPLICATION_JSON)
                .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
                .build();
    }


    protected URI addParameters(URI uri, HashMap<String, String> params) {
        String query = uri.getQuery();
        StringBuilder builder = new StringBuilder();

        if (query != null)
            builder.append(query);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String keyValueParam = entry.getKey() + "=" + entry.getValue();
            if (!builder.toString().isEmpty())
                builder.append("&");
            builder.append(keyValueParam);
        }
        return URI.create(uri + "?" + builder);
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        return objectMapper.readValue(body, tClass);
    }
}
