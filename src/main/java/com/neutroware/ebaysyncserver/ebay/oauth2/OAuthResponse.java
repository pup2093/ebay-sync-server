package com.neutroware.ebaysyncserver.ebay.oauth2;

import java.util.Optional;

public class OAuthResponse {
    private Optional<AccessToken> accessToken;
    private Optional<RefreshToken> refreshToken;
    private String errorMessage;

    public OAuthResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public OAuthResponse(Optional<AccessToken> accessToken, Optional<RefreshToken> refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public Optional<AccessToken> getAccessToken() {
        if (accessToken == null) {
            return Optional.empty();
        } else {
            return accessToken;
        }
    }

    public void setAccessToken(Optional<AccessToken> accessToken) {
        this.accessToken = accessToken;
    }

    public Optional<RefreshToken> getRefreshToken() {
        if (refreshToken == null) {
            return Optional.empty();
        } else {
            return refreshToken;
        }
    }

    public void setRefreshToken(Optional<RefreshToken> refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OAuthResponse{");
        sb.append("accessToken=").append(accessToken);
        sb.append(", refreshToken=").append(refreshToken);
        sb.append(", errorMessage='").append(errorMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}