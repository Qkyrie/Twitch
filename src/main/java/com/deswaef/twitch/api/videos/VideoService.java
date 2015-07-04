package com.deswaef.twitch.api.videos;

import com.deswaef.twitch.api.videos.domain.Video;
import com.deswaef.twitch.api.videos.domain.VideosResponse;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

/**
 * User: Quinten
 * Date: 5-7-2015
 * Time: 00:49
 *
 * @author Quinten De Swaef
 */
public interface VideoService {

    @GET("/videos/{id}")
    Video video(@Path("id")String id);

    @GET("/channels/{channel}/videos")
    VideosResponse videos(@Path("channel")String channel);


}
