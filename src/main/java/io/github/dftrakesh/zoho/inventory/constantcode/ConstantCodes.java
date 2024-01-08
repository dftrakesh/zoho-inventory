package io.github.dftrakesh.zoho.inventory.constantcode;

public interface ConstantCodes {

    String VERSION = "v1/";
    String ITEM_ENDPOINT = "items/";
    String CLIENT_ID = "client_id";
    String GRANT_TYPE = "grant_type";
    String REDIRECT_URI = "redirect_uri";
    String CONTENT_TYPE = "Content-Type";
    String CLIENT_SECRET = "client_secret";
    String REFRESH_TOKEN = "refresh_token";
    String TOKEN_NAME = "Zoho-oauthtoken ";
    String AUTHORIZATION_HEADER = "Authorization";
    String AUTHORIZATION_CODE = "authorization_code";
    String CONTENT_VALUE_APPLICATION_JSON = "application/json";

    String API_BASED_END_POINT = "https://www.zohoapis.%s/inventory/";
    String OAUTH_BASED_END_POINT = "https://accounts.zoho.%s/oauth/v2/token/";

    int MAX_ATTEMPTS = 30;
    int TIME_OUT_DURATION = 60000;
    int TOO_MANY_REQUEST_EXCEPTION_CODE = 429;
}
