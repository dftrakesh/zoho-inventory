package io.zohoinventory.models.itemapi.getmethods;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemWrapper {
    private Item item;
    private String code;
    private String message;
}
