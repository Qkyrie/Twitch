package com.deswaef.twitch.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User: Quinten
 * Date: 12-9-2014
 * Time: 11:53
 *
 * @author Quinten De Swaef
 */
@ConfigurationProperties(value = "twitch", ignoreUnknownFields = true)
public class TwitchProperties {
    private String baseUrl = "";
    private String clientSecret = "";
    private String clientId = "";
    private String redirectURI = "";

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRedirectURI() {
        return redirectURI;
    }

    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }
}
