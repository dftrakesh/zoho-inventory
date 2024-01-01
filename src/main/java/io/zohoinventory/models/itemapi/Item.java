package io.zohoinventory.models.itemapi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Item {
    private String groupId;
    private String groupName;
    private String itemId;
    private String name;
    private String itemName;
    private String unit;
    private String status;
    private String source;
    private Boolean isComboProduct;
    private Boolean isLinkedWithZohocrm;
    private String zcrmProductId;
    private String description;
    private String brand;
    private String manufacturer;
    private Double rate;
    private String taxId;
    private String taxName;
    private Double taxPercentage;
    private String purchaseAccountId;
    private String purchaseAccountName;
    private String accountId;
    private String accountName;
    private String purchaseDescription;
    private Double purchaseRate;
    private String itemType;
    private String productType;
    private Double stockOnHand;
    private Boolean hasAttachment;
    private Boolean isReturnable;
    private Double availableStock;
    private Double actualAvailableStock;
    private String attributeId1;
    private String attributeId2;
    private String attributeId3;
    private String attributeName1;
    private String attributeName2;
    private String attributeName3;
    private String attributeType1;
    private String attributeType2;
    private String attributeType3;
    private String attributeOptionId1;
    private String attributeOptionId2;
    private String attributeOptionId3;
    private String attributeOptionName1;
    private String attributeOptionName2;
    private String attributeOptionName3;
    private String attributeOptionData1;
    private String attributeOptionData2;
    private String attributeOptionData3;
    private String sku;
    private String upc;
    private String ean;
    private String isbn;
    private String partNumber;
    private Double reorderLevel;
    private String imageName;
    private String imageType;
    private String imageDocumentId;
    private Date createdTime;
    private Date lastModifiedTime;
    private String length;
    private String width;
    private String height;
    private String weight;
    private String weightUnit;
    private String dimensionUnit;
}