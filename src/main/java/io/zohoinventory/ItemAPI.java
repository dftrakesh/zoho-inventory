package io.zohoinventory;

import io.zohoinventory.models.authenticationapi.AccessCredentials;
import io.zohoinventory.models.itemapi.ItemWrapper;
import io.zohoinventory.models.itemapi.ItemsWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.zohoinventory.constantcode.ConstantCodes.ITEM_ENDPOINT;

public class ItemAPI extends ZohoInventorySdk {

    public ItemAPI(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    public ItemsWrapper getItems(HashMap<String, String> params) {
        URI uri = baseUrl(ITEM_ENDPOINT);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ItemsWrapper.class);
    }

    public ItemWrapper getItemsById(String itemId, HashMap<String, String> params) {
        URI uri = baseUrl(ITEM_ENDPOINT + itemId);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ItemWrapper.class);
    }
}
