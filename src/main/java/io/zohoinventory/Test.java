package io.zohoinventory;


import io.zohoinventory.models.authenticationapi.AccessCredentials;
import io.zohoinventory.models.itemapi.ItemWrapper;
import io.zohoinventory.models.itemapi.ItemsWrapper;
import io.zohoinventory.models.orderapi.OrdersWrapper;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

        //SpringApplication.run(ZohoinventoryApplication.class, args);

        AccessCredentials accessCredentials = new AccessCredentials();

        accessCredentials.setAccessToken("1000.20172c40477757f06eb8a5bcf6f84d9b.e56eca613a6fa6196d6ec00ae418dd1d");
        accessCredentials.setExpiresInTime(LocalDateTime.now().plusSeconds(3600));
        accessCredentials.setApiDomain("https://www.zohoapis.in");
        accessCredentials.setClientId("1000.UYSZWLGW2HG7IWBXNXWXBLQO8D9BWV");
        accessCredentials.setClientSecret("748e20dd942cd5ad15857bfce2aac3df86536cdcf8");
        accessCredentials.setRedirectUri("https://www.google.com/");
        accessCredentials.setTokenType("Bearer");
        accessCredentials.setRefreshToken("1000.76fc1a09092be4894da5de17c87b7b7f.e179ad927b4b82092f40bdf0c8fa6e2c");
        accessCredentials.setScope("ZohoInventory.FullAccess.all");

        ItemAPI itemAPI = new ItemAPI(accessCredentials);
        HashMap<String, String> params = new HashMap<>();
        params.put("organization_id","60026058175");
        ItemWrapper items = itemAPI.getItemsById(params, "1618686000000023038");
        System.out.println(items);

        ItemsWrapper items2 = itemAPI.getItems(params);
        System.out.println(items2);
    }
}
