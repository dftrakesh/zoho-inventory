package io.zohoinventory.models.authenticationapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessTokenResponse {
    private String scope;
    private String tokenType;
    private String apiDomain;
    private Integer expiresIn;
    private String accessToken;
}
