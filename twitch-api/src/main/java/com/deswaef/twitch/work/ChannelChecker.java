package com.deswaef.twitch.work;

import com.deswaef.twitch.domain.TwitchChannel;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * User: Quinten
 * Date: 23-8-2014
 * Time: 01:04
 *
 * @author Quinten De Swaef
 */
public class ChannelChecker {

    private String baseUrl;

    public Optional<TwitchChannel> channel(String channelName) {

        try {
            RestTemplate template = new RestTemplate();
            return Optional.ofNullable(template.getForObject(String.format("%s/channels/%s", baseUrl, channelName.toLowerCase()), TwitchChannel.class));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public ChannelChecker url(String url)
    {
        this.baseUrl = url;
        return this;
    }

}
