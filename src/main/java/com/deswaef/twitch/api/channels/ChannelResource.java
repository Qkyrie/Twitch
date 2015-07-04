package com.deswaef.twitch.api.channels;

import com.deswaef.twitch.api.channels.domain.TwitchChannel;
import com.deswaef.twitch.exception.Assert;
import retrofit.RestAdapter;

import java.util.Optional;

/**
 * User: Quinten
 * Date: 23-8-2014
 * Time: 01:04
 *
 * @author Quinten De Swaef
 */
public class ChannelResource {

    private ChannelService channelService;


    public Optional<TwitchChannel> channel(String channelName) {
        Assert.notNull(channelName, "please enter a channelname");
        try {
            return Optional.ofNullable(channelService.channel(channelName));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public ChannelResource url(RestAdapter url) {
        this.channelService = url.create(ChannelService.class);
        return this;
    }

}
