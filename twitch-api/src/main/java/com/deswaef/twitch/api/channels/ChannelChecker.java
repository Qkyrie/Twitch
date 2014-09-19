package com.deswaef.twitch.api.channels;

import com.deswaef.twitch.api.APIResource;
import com.deswaef.twitch.api.channels.domain.TwitchChannel;
import com.deswaef.twitch.rest.RestTemplateProvider;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * User: Quinten
 * Date: 23-8-2014
 * Time: 01:04
 *
 * @author Quinten De Swaef
 */
public class ChannelChecker extends APIResource {

    private String baseUrl;

    public ChannelChecker() {
        super();
    }

    public ChannelChecker(RestTemplateProvider rtProvider) {
        super(rtProvider);
    }

    public Optional<TwitchChannel> channel(String channelName) {
        Assert.notNull(baseUrl, "base url for twitch must be set");
        try {
            return Optional.ofNullable(rest().getForObject(String.format("%s/channels/%s", baseUrl, channelName.toLowerCase()), TwitchChannel.class));
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
