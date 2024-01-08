package io.github.dftrakesh.zoho.inventory.models.itemapi.getdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsWrapper {
    private String code;
    private String message;
    private List<Item> items;
}
