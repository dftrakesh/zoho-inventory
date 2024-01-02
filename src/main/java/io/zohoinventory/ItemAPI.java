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

    public ItemsWrapper getItems(HashMap<String, String> params)
    {
        refreshAccessToken();
        URI uri = URI.create(API_BASED_END_POINT.concat(SLASH_CHARACTER)
                .concat(VERSION)
                .concat(SLASH_CHARACTER)
                .concat(ITEM_ENDPOINT));

        uri = addParameters(uri, params);

        HttpRequest request = get(uri);

        return getRequestWrapped(request, ItemsWrapper.class);
    }

    public ItemWrapper getItemsById(HashMap<String, String> params, String item_id) {
        refreshAccessToken();
        URI uri = URI.create(API_BASED_END_POINT + SLASH_CHARACTER +
                VERSION + SLASH_CHARACTER +
                ITEM_ENDPOINT + SLASH_CHARACTER +
                item_id);

        uri = addParameters(uri, params);

        HttpRequest request = get(uri);

        return getRequestWrapped(request, ItemWrapper.class);
    }
}
