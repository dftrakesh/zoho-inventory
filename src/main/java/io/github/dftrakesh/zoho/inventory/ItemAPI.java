package io.github.dftrakesh.zoho.inventory;

import io.github.dftrakesh.zoho.inventory.models.authenticationapi.AccessCredentials;
import io.github.dftrakesh.zoho.inventory.models.itemapi.ItemWrapper;
import io.github.dftrakesh.zoho.inventory.models.itemapi.ItemsWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dftrakesh.zoho.inventory.constantcode.ConstantCodes.ITEM_ENDPOINT;

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

    public  ItemWrapper getItemById(String itemId, HashMap<String, String> params) {
        URI uri = baseUrl(ITEM_ENDPOINT + itemId);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ItemWrapper.class);
    }
}
