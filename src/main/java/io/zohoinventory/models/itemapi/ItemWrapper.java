package io.zohoinventory.models.itemapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemWrapper {
    private String code;
    private String message;
    private Item item;
}
