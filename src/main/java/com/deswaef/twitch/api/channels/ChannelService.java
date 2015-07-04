package com.deswaef.twitch.api.channels;

import com.deswaef.twitch.api.channels.domain.TwitchChannel;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * User: Quinten
 * Date: 5-7-2015
 * Time: 01:03
 *
 * @author Quinten De Swaef
 */
public interface ChannelService {
    @GET("/channels/{channel}")
    TwitchChannel channel(@Path("channel") String channel);
}
