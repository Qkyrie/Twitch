package com.deswaef.twitch.configuration;

import com.deswaef.twitch.work.ChannelChecker;
import com.deswaef.twitch.work.StreamChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

/**
 * User: Quinten
 * Date: 22-8-2014
 * Time: 20:53
 *
 * @author Quinten De Swaef
 */
@Configuration
@EnableConfigurationProperties(TwitchProperties.class)
public class TwitchAutoConfiguration {

    @Autowired
    private TwitchProperties twitchProperties;

    @Bean
    @ConditionalOnMissingBean(Twitch.class)
    public Twitch provideTwitch() {
        validateProperties();
        return Twitch.newTwitchInstance(
                getBaseUrl(),
                getClientId(),
                getClientSecret(),
                getRedirectURI());
    }

    private void validateProperties() {
        Assert.state(!getBaseUrl().isEmpty(), "the provided twitch url can not be empty!\nPlease Provide an url for the twitch API.");
        Assert.state(!getClientId().isEmpty(), "the provided twitch client id can not be empty!\nPlease Provide your client id for the twitch API.");
        Assert.state(!getClientSecret().isEmpty(), "the provided twitch client secret can not be empty!\nPlease Provide your client secret for the twitch API.");
        Assert.state(!getRedirectURI().isEmpty(), "the provided twitch redirect uri can not be empty!\nPlease Provide a redirect URI for the twitch API.");
    }

    private String getBaseUrl() {
        return twitchProperties.getBaseUrl();
    }

    private String getRedirectURI() {
        return twitchProperties.getRedirectURI();
    }

    private String getClientId() {
        return twitchProperties.getClientId();
    }

    private String getClientSecret() {
        return twitchProperties.getClientSecret();
    }


}
