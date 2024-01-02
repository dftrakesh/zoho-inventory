package io.zohoinventory.models.orderapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersWrapper {
    private String code;
    private String message;
    private List<Order> salesorders;
}
