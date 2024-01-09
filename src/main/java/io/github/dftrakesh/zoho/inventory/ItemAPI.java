package io.github.dftrakesh.zoho.inventory;

import io.github.dftrakesh.zoho.inventory.models.authenticationapi.AccessCredentials;
import io.github.dftrakesh.zoho.inventory.models.itemapi.getitem.ItemWrapper;
import io.github.dftrakesh.zoho.inventory.models.itemapi.getitem.ItemsWrapper;
import io.github.dftrakesh.zoho.inventory.models.itemapi.updateitem.UpdateRecordResponse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dftrakesh.zoho.inventory.constantcode.ConstantCodes.ITEM_ENDPOINT;
import static io.github.dftrakesh.zoho.inventory.constantcode.ConstantCodes.UPDATE_ITEM_ENDPOINT;

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

    public ItemWrapper getItemById(String itemId, HashMap<String, String> params) {
        URI uri = baseUrl(ITEM_ENDPOINT + itemId);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, ItemWrapper.class);
    }

    public UpdateRecordResponse updateItem(HashMap<String, String> params, String updateRecordData) {
        URI uri = baseUrl(UPDATE_ITEM_ENDPOINT);
        uri = addParameters(uri, params);
        HttpRequest request = post(uri, updateRecordData);

        return getRequestWrapped(request, UpdateRecordResponse.class);
    }
}
