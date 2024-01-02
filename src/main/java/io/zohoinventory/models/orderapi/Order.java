package io.zohoinventory.models.orderapi;

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
public class Order {
    private String salesOrderId;
    private String zcrmPotentialId;
    private String zcrmPotentialName;
    private String customerName;
    private String customerId;
    private String email;
    private String deliveryDate;
    private String companyName;
    private String colorCode;
    private String currentSubStatusId;
    private String currentSubStatus;
    private String pickupLocationId;
    private String salesorderNumber;
    private String referenceNumber;
    private String date;
    private String shipmentDate;
    private String shipmentDays;
    private String dueByDays;
    private String dueInDays;
    private String currencyId;
    private String source;
    private String currencyCode;
    private Double total;
    private Double bcyTotal;
    private Double totalInvoicedAmount;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdTime;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime lastModifiedTime;
    private Boolean isEmailed;
    private Double quantity;
    private Double quantityInvoiced;
    private Double quantityPacked;
    private Double quantityShipped;
    private String orderStatus;
    private String invoicedStatus;
    private String paidStatus;
    private String shippedStatus;
    private String status;
    private Boolean isDropShipment;
    private Boolean isBackorder;
    private Boolean isManuallyFulfilled;
    private String salesChannel;
    private String salesChannelFormatted;
    private String salespersonName;
    private Boolean hasAttachment;
    private Double balance;
    private String deliveryMethod;
    private String deliveryMethodId;
}
