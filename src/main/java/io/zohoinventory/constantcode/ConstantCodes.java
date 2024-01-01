package io.zohoinventory.constantcode;

public interface ConstantCodes {

    String VERSION = "v1";
    String SLASH_CHARACTER = "/";
    String ITEM_ENDPOINT = "items";
    String CLIENT_ID = "client_id";
    String GRANT_TYPE = "grant_type";
    String REDIRECT_URI = "redirect_uri";
    String CLIENT_SECRET = "client_secret";
    String REFRESH_TOKEN = "refresh_token";
    String TOKEN_NAME = "Zoho-oauthtoken ";
    String CONTENT_VALUE = "application/json";
    String AUTHORIZATION_HEADER = "Authorization";
    String AUTHORIZATION_CODE = "authorization_code";

    String API_BASED_END_POINT = "https://www.zohoapis.in/inventory";
    String OAUTH_BASED_END_POINT = "https://accounts.zoho.in/oauth/v2/token";

    int MAX_ATTEMPTS = 50;
    int TIME_OUT_DURATION = 3000;
    int TOO_MANY_REQUEST_EXCEPTION_CODE = 429;
}
