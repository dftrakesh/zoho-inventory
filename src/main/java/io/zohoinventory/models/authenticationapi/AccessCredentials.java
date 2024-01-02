package io.zohoinventory.models.authenticationapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessCredentials {
    private String scope;
    private String clientId;
    private String apiDomain;
    private String tokenType;
    private String accessToken;
    private String redirectUri;
    private String clientSecret;
    private String refreshToken;
    private LocalDateTime expiresInTime;
}
