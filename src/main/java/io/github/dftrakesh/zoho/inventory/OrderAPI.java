package io.github.dftrakesh.zoho.inventory;

import io.github.dftrakesh.zoho.inventory.models.authenticationapi.AccessCredentials;
import io.github.dftrakesh.zoho.inventory.models.orderapi.OrdersWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dftrakesh.zoho.inventory.constantcode.ConstantCodes.SALESORDER_ENDPOINT;

public class OrderAPI extends ZohoInventorySdk {
    public OrderAPI(AccessCredentials accessCredentials) {
        super(accessCredentials);
    }

    public OrdersWrapper getOrders(HashMap<String, String> params) {
        URI uri = baseUrl(SALESORDER_ENDPOINT);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        return getRequestWrapped(request, OrdersWrapper.class);
    }
}
