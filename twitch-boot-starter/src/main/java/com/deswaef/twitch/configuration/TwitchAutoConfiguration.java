package com.deswaef.twitch.configuration;

import com.deswaef.twitch.configuration.Twitch;
import com.deswaef.twitch.work.ChannelChecker;
import com.deswaef.twitch.work.StreamChecker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.Assert;

/**
 * User: Quinten
 * Date: 22-8-2014
 * Time: 20:53
 *
 * @author Quinten De Swaef
 */
@Configuration
@PropertySource(value = "classpath:twitch.properties")
public class TwitchAutoConfiguration {

    @Value("${twitch.url}")
    private String url;

    @Bean
    public StreamChecker streamChecker() {
        return new StreamChecker()
                .url(url);
    }

    @Bean
    public ChannelChecker channelChecker() {
        return new ChannelChecker()
                .url(url);
    }

    @Bean
    @ConditionalOnMissingBean(Twitch.class)
    public Twitch provideTwitch() {
        Assert.notNull(url, "the provided twitch url can not be empty");
        return new Twitch()
                .channels(channelChecker())
                .streams(streamChecker())
                .url(url);
    }


}
