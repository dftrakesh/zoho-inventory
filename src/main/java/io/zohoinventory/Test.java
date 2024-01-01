package io.zohoinventory;


import io.zohoinventory.models.authenticationapi.AccessCredentials;
import io.zohoinventory.models.itemapi.Items;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Test {

    @SneakyThrows
    public static void main(String[] args) {

        //SpringApplication.run(ZohoinventoryApplication.class, args);
        AccessCredentials accessCredentials = new AccessCredentials(
                "ZohoInventory.FullAccess.all",
                "1000.50YJPYXKDFNRYHAFYMV2F244FZZ61F",
                "https://www.zohoapis.in",
                "Bearer",
                "b597be69646eb29a14c8ffb25f34d936d53e043434",
                LocalDateTime.now().plusSeconds(3600),
                "1000.c1cf11b0455b1923e86d05d0acdf2aca.1c2939196f4a4569bd93030e9f839ae4",
                "1000.8552b2c0458e3f67aa976b593ba2d987.71b9a96523831d87855067823f5308a2",
                "https://www.google.com/"
        );
        ItemAPI itemAPI = new ItemAPI(accessCredentials);
        HashMap<String, String> params = new HashMap<>();
        params.put("organization_id","60026058175");

        Items items = itemAPI.getItems(params);
        System.out.println("items = " + items);
        Items items2 = itemAPI.getItemsById(params,"1618686000000023038");
        System.out.println(items2);
    }
}
