package io.github.dftrakesh.zoho.inventory.models.authenticationapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ZohoInventoryAccessTokenResponse {
    private String scope;
    private String tokenType;
    private String apiDomain;
    private Integer expiresIn;
    private String accessToken;
    private String refreshToken;
}
