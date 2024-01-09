package io.github.dftrakesh.zoho.inventory.models.itemapi.updateitem;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateRecordWrapper {
    private String code;
    private String message;
    private UpdateRecordRequest inventoryAdjustment;
}
