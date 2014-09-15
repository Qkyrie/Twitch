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
        Assert.state(!getBaseUrl().isEmpty(), "the provided twitch url can not be empty!\nPlease Provide an url for the twitch API.");
        return Twitch.newTwitchInstance(getBaseUrl());
    }

    private String getBaseUrl() {
        return twitchProperties.getBaseUrl();
    }


}
