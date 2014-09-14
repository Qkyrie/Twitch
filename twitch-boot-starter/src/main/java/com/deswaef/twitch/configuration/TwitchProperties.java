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

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
