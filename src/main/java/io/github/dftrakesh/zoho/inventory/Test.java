package io.github.dftrakesh.zoho.inventory;

import io.github.dftrakesh.zoho.inventory.models.authenticationapi.AccessCredentials;

import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        AccessCredentials accessCredentials = new AccessCredentials();
        accessCredentials.setScope("Zoho.FullAccess");
        accessCredentials.setClientId("1000.69IBXIKAYKKJII4PH0BI06S0MVCDJC");
        accessCredentials.setApiDomain("https://vivek.dakshyafreondtech.com");
        accessCredentials.setTokenType("refresh_token");
        accessCredentials.setAccessToken("1000.56b630b781c20518700c42b1a310861c.3857bbe7c321a952a504ab8660636ef1");
        accessCredentials.setRedirectUri("https://vivek.dakshyafreondtech.com");
        accessCredentials.setClientSecret("2f985e9d696d0c702067f2bb68d980fe38af96a9c7");
        accessCredentials.setRefreshToken("1000.06040f4939287a9418e9d0a5baed44a5.2685f34f82b72369701eef474ae59d4b");
        accessCredentials.setExpiresInTime(LocalDateTime.now()); // You can replace this with the appropriate LocalDateTime value
        accessCredentials.setTopLevelDomain("in");

        ZohoInventorySdk zohoInventorySdk = new ZohoInventorySdk(accessCredentials);

    }
}
