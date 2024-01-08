package io.github.dftrakesh.zoho.inventory.models.itemapi.updatedata;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateRecordResponse {
    private String code;
    private String message;
    private List<UpdateRecordData> inventoryAdjustment;
}
