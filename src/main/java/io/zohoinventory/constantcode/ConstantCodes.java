package io.zohoinventory.constantcode;

public interface ConstantCodes {
    String SLASH_CHARACTER = "/";
    String VERSION = "v1";
    String ITEM_ENDPOINT = "items";
    String CONTENT_VALUE = "application/json";
    String AUTHORIZATION_HEADER = "Authorization";
    String TOKEN_NAME = "Zoho-oauthtoken ";
    String GRANT_TYPE = "grant_type";
    String AUTHORIZATION_CODE = "authorization_code";
    String CLIENT_ID = "client_id";
    String CLIENT_SECRET = "client_secret";
    String REFRESH_TOKEN = "refresh_token";
    String REDIRECT_URI = "redirect_uri";

    String API_BASED_END_POINT = "https://www.zohoapis.in/inventory";
    String OAUTH_BASED_END_POINT = "https://accounts.zoho.in/oauth/v2/token";

    int MAX_ATTEMPTS = 50;
    int TIME_OUT_DURATION = 3000;
    int TOO_MANY_REQUEST_EXCEPTION_CODE = 429;
}
