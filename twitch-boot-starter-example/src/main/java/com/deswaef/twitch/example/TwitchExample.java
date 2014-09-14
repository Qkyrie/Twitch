package com.deswaef.twitch.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

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
    public static void main(final String[] args) throws Exception {
        SpringApplication.run(TwitchExample.class);
    }
}


