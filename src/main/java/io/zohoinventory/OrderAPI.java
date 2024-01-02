package io.zohoinventory;

import io.zohoinventory.models.authenticationapi.AccessCredentials;
import io.zohoinventory.models.orderapi.OrdersWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.zohoinventory.constantcode.ConstantCodes.*;

public class OrderAPI extends ZohoInventorySdk {
    public OrderAPI(AccessCredentials accessCredentials)
    {
        super(accessCredentials);
    }

    public OrdersWrapper getOrders(HashMap<String, String> params)
    {
        refreshAccessToken();

        URI uri = URI.create(API_BASED_END_POINT + SLASH_CHARACTER +
                VERSION + SLASH_CHARACTER +
                SALESORDER_ENDPOINT);

        uri = addParameters(uri, params);

        HttpRequest request = get(uri);

        return getRequestWrapped(request, OrdersWrapper.class);
    }
}
