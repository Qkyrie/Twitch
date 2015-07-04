package com.deswaef.twitch.api.streams;

import com.deswaef.twitch.api.streams.domain.StreamCheck;
import com.deswaef.twitch.api.streams.domain.Streams;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * User: Quinten
 * Date: 5-7-2015
 * Time: 00:58
 *
 * @author Quinten De Swaef
 */
public interface StreamService {

    @GET("/streams")
    Streams streams();

    @GET("/streams/{stream}")
    StreamCheck stream(@Path("stream") String stream);

}
