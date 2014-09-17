package com.deswaef.twitch.example;

import com.deswaef.twitch.configuration.Twitch;
import com.deswaef.twitch.domain.TwitchChannel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * User: Quinten
 * Date: 14-9-2014
 * Time: 01:52
 *
 * @author Quinten De Swaef
 */
@Configuration
@EnableAutoConfiguration
public class TwitchExample {

    private Log logger = LogFactory.getLog(TwitchExample.class);

    @Autowired
    private Twitch twitch;

    @PostConstruct
    private void startUp() {
        Optional<TwitchChannel> streamingforanimals = twitch.channels().channel("streamingforanimals");
        streamingforanimals.ifPresent(channel -> {
            logger.info(channel.toString());
        });
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(TwitchExample.class);
    }
}


