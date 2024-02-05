package io.github.dftrakesh.zoho.inventory;

import io.github.dftrakesh.zoho.inventory.models.authenticationapi.ZohoInventoryAccessCredentials;
import io.github.dftrakesh.zoho.inventory.models.authenticationapi.ZohoInventoryAccessTokenResponse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dftrakesh.zoho.inventory.constantcode.ConstantCodes.OAUTH_BASED_END_POINT;

public class ZohoAccessCredentialsAPI extends ZohoInventorySdk{

    public ZohoAccessCredentialsAPI(ZohoInventoryAccessCredentials accessCredential) {
        super(accessCredential);
    }

    public ZohoInventoryAccessTokenResponse getAccessCredentials(String topLevelDomain, HashMap<String, String> params) {
        URI uri = baseUrl(OAUTH_BASED_END_POINT, topLevelDomain);
        uri = addParameters(uri, params);
        HttpRequest request = postWithNoBody(uri);

        return getRequestWrapped(request, ZohoInventoryAccessTokenResponse.class);
    }
}
