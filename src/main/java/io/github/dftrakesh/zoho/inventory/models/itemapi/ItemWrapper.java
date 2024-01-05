package io.github.dftrakesh.zoho.inventory.models.itemapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemWrapper {
    private Item item;
    private String code;
    private String message;
}
