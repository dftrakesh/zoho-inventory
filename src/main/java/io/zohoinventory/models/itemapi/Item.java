package io.zohoinventory.models.itemapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.zohoinventory.models.LocalDateTimeDeserializer;
import io.zohoinventory.models.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Item {
    private String sku;
    private String upc;
    private String ean;
    private Double rate;
    private String isbn;
    private String unit;
    private String name;
    private String brand;
    private String taxId;
    private String width;
    private String itemId;
    private String status;
    private String source;
    private String length;
    private String height;
    private String weight;
    private String groupId;
    private String taxName;
    private String itemType;
    private String itemName;
    private String groupName;
    private String imageName;
    private String imageType;
    private String accountId;
    private String partNumber;
    private String weightUnit;
    private String productType;
    private Double stockOnHand;
    private String accountName;
    private String description;
    private Double purchaseRate;
    private Double reorderLevel;
    private String attributeId1;
    private String attributeId2;
    private String attributeId3;
    private String manufacturer;
    private Boolean isReturnable;
    private String dimensionUnit;
    private Double taxPercentage;
    private String zcrmProductId;
    private Boolean hasAttachment;
    private String attributeName1;
    private String attributeName2;
    private String attributeName3;
    private String attributeType1;
    private String attributeType2;
    private String attributeType3;
    private Double availableStock;
    private Boolean isComboProduct;
    private String imageDocumentId;
    private String purchaseAccountId;
    private String attributeOptionId1;
    private String attributeOptionId2;
    private String attributeOptionId3;
    private String purchaseDescription;
    private String purchaseAccountName;
    private Double actualAvailableStock;
    private String attributeOptionName1;
    private String attributeOptionName2;
    private String attributeOptionName3;
    private String attributeOptionData1;
    private String attributeOptionData2;
    private String attributeOptionData3;
    private Boolean isLinkedWithZohocrm;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime lastModifiedTime;
}
