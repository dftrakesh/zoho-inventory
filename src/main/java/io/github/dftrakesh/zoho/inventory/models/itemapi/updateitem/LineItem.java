package io.github.dftrakesh.zoho.inventory.models.itemapi.updateitem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LineItem {
    private String name;
    private String itemId;
    private Integer itemOrder;
    private Double quantityAdjusted;
    private Double quantityAdjustedFormatted;
}
