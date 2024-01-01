package io.zohoinventory;

import io.zohoinventory.models.authenticationapi.AccessCredentials;
import io.zohoinventory.models.itemapi.Item;
import io.zohoinventory.models.itemapi.Items;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.zohoinventory.constantcode.ConstantCodes.*;

public class ItemAPI extends ZohoInventorySdk{

    public ItemAPI(AccessCredentials accessCredentials){
        super(accessCredentials);
    }

    @SneakyThrows
    public Items getItems(HashMap<String, String> params)
    {
        refreshAccessToken();
        URIBuilder uriBuilder =new URIBuilder(API_BASED_END_POINT.concat(SLASH_CHARACTER)
                .concat(VERSION)
                .concat(SLASH_CHARACTER)
                .concat(ITEM_ENDPOINT));

        addParameters(uriBuilder, params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.CONTENT_TYPE, CONTENT_VALUE)
                .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
                .build();
        return getRequestWrapped(request, Items.class);
    }

    @SneakyThrows
    public Items getItemsById(HashMap<String, String> params, String item_id) {
        refreshAccessToken();
        URIBuilder uriBuilder =new URIBuilder(API_BASED_END_POINT.concat(SLASH_CHARACTER)
                .concat(VERSION)
                .concat(SLASH_CHARACTER)
                .concat(ITEM_ENDPOINT)
                .concat(SLASH_CHARACTER));

        addParameters(uriBuilder, params);
        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.CONTENT_TYPE, CONTENT_VALUE)
                .headers(AUTHORIZATION_HEADER, TOKEN_NAME.concat(accessCredential.getAccessToken()))
                .build();
        Items items = getRequestWrapped(request, Items.class);
        List<Item> data = new ArrayList<>();

        for (Item item : items.getItems()) {
            if (item.getItem_id().equals(item_id)) {
                data.add(item);
                items.setItems(data);
                return items;
            }
        }
        return null;
    }
}
