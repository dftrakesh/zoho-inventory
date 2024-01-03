package io.zohoinventory;

import io.zohoinventory.models.authenticationapi.AccessCredentials;
import io.zohoinventory.models.itemapi.getmethods.ItemWrapper;
import io.zohoinventory.models.itemapi.getmethods.ItemsWrapper;
import io.zohoinventory.models.itemapi.updatemethods.UpdateRecordResponse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.zohoinventory.constantcode.ConstantCodes.*;

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

    public UpdateRecordResponse updateItem(String item_id, HashMap<String, String> params, String updateRecordData) {
        URI uri = baseUrl(ITEM_ENDPOINT + item_id);
        uri = addParameters(uri, params);
        HttpRequest request = put(uri, updateRecordData);

        return getRequestWrapped(request, UpdateRecordResponse.class);
    }
}
