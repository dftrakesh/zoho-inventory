package io.zohoinventory;

import io.zohoinventory.models.authenticationapi.AccessCredentials;
import io.zohoinventory.models.itemapi.ItemWrapper;
import io.zohoinventory.models.itemapi.ItemsWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.zohoinventory.constantcode.ConstantCodes.*;

public class ItemAPI extends ZohoInventorySdk{

    public ItemAPI(AccessCredentials accessCredentials){
        super(accessCredentials);
    }

    public ItemsWrapper getItems(HashMap<String, String> params) {
        refreshAccessToken();
        String UriString = API_BASED_END_POINT + VERSION + ITEM_ENDPOINT;
        URI uri = URI.create(UriString);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ItemsWrapper.class);
    }

    public ItemWrapper getItemsById(HashMap<String, String> params, String item_id) {
        refreshAccessToken();
        String UriString = API_BASED_END_POINT + VERSION + ITEM_ENDPOINT  + item_id;
        URI uri = URI.create(UriString);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ItemWrapper.class);
    }
}
