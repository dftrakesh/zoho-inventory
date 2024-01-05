package io.github.dftrakesh.models.authenticationapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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
    private String apiUri;
    private String oauthUri;
    private String topLevelDomain;
}
