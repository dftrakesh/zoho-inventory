package io.github.dftrakesh.zoho.inventory;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dftrakesh.zoho.inventory.models.authenticationapi.ZohoInventoryAccessCredentials;
import io.github.dftrakesh.zoho.inventory.models.authenticationapi.ZohoInventoryAccessTokenResponse;
import io.github.dftrakesh.zoho.inventory.models.itemapi.updateitem.UpdateRecordRequest;
import lombok.SneakyThrows;

import javax.lang.model.SourceVersion;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static io.github.dftrakesh.zoho.inventory.constantcode.ConstantCodes.*;

public class ZohoInventorySdk {

    protected HttpClient client;
    private final ObjectMapper objectMapper;
    protected ZohoInventoryAccessCredentials accessCredential;

    public ZohoInventorySdk(ZohoInventoryAccessCredentials accessCredential) {
        client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.accessCredential = accessCredential;
    }

    @SneakyThrows
    protected <T> T getRequestWrapped(HttpRequest request, Class<T> tclass) {

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

    protected void refreshAccessToken() {

        if (accessCredential.getAccessToken() == null || accessCredential.getExpiresInTime() == null || LocalDateTime.now().isAfter(accessCredential.getExpiresInTime())) {
            HashMap<String, String> params = new HashMap<>();
            params.put(REFRESH_TOKEN, accessCredential.getRefreshToken());
            params.put(CLIENT_ID,accessCredential.getClientId());
            params.put(CLIENT_SECRET,accessCredential.getClientSecret());
            params.put(GRANT_TYPE,AUTHORIZATION_CODE);

            String oauthUrl = String.format(OAUTH_BASED_END_POINT, accessCredential.getTopLevelDomain());
            URI uriBuilder = URI.create(oauthUrl);
            uriBuilder = addParameters(uriBuilder, params);

            HttpRequest request = HttpRequest.newBuilder(uriBuilder)
                .POST(HttpRequest.BodyPublishers.noBody())
                .header(CONTENT_TYPE, CONTENT_VALUE_APPLICATION_JSON)
                .build();

            ZohoInventoryAccessTokenResponse accessTokenResponse = getRequestWrapped(request, ZohoInventoryAccessTokenResponse.class);
            accessCredential.setAccessToken(accessTokenResponse.getAccessToken());
            accessCredential.setExpiresInTime(LocalDateTime.now().plusSeconds(accessTokenResponse.getExpiresIn()));
        }
    }

    protected HttpRequest get(URI uri) {
        refreshAccessToken();
        return HttpRequest.newBuilder(uri)
            .GET()
            .header(CONTENT_TYPE, CONTENT_VALUE_APPLICATION_JSON)
            .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
            .build();
    }

    protected HttpRequest post(URI uri, UpdateRecordRequest updateRecordData) {
        refreshAccessToken();
        return HttpRequest.newBuilder(uri)
            .POST(HttpRequest.BodyPublishers.ofString(toString(updateRecordData)))
            .header(CONTENT_TYPE, CONTENT_VALUE_APPLICATION_JSON)
            .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
            .build();
    }

    protected URI addParameters(URI uri, HashMap<String, String> params) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String keyValueParam = String.format("%s=%s", entry.getKey(), entry.getValue());
            if (!builder.toString().isEmpty()) {
                builder.append("&");
            }
            builder.append(keyValueParam);
        }
        return URI.create(uri + "?" + builder);
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        return objectMapper.readValue(body, tClass);
    }

    public URI baseUrl(String path) {
        String baseUrl = String.format(API_BASED_END_POINT, accessCredential.getTopLevelDomain());
        return URI.create(baseUrl + VERSION + path);
    }

    @SneakyThrows
    public String toString(Object object) {
        return objectMapper.writeValueAsString(object);
    }
}
