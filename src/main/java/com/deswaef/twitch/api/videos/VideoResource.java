package com.deswaef.twitch.api.videos;

import com.deswaef.twitch.api.videos.domain.Video;
import com.deswaef.twitch.api.videos.domain.VideosResponse;
import retrofit.RestAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * User: Quinten
 * Date: 27-9-2014
 * Time: 01:41
 *
 * @author Quinten De Swaef
 */
public class VideoResource {

    private VideoService videoService;

    public Optional<Video> video(String id) {
        try {
            return Optional.ofNullable(videoService.video(id));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public List<Video> videos(String channel) {
        Optional<VideosResponse> responseWrapper = null;
        try {
            responseWrapper = Optional.ofNullable(videoService.videos(channel));
        } catch (Exception excepton) {
            responseWrapper = Optional.empty();
        }

        if (responseWrapper.isPresent()) {
            return responseWrapper.get().getVideos();
        } else {
            return new ArrayList<>();
        }
    }

    public VideoResource url(RestAdapter restAdapter) {
        this.videoService = restAdapter.create(VideoService.class);
        return this;
    }

}
