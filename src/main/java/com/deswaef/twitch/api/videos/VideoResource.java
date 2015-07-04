package com.deswaef.twitch.api.videos;

import com.deswaef.twitch.api.APIResource;
import com.deswaef.twitch.api.videos.domain.Video;
import com.deswaef.twitch.api.videos.domain.VideosResponse;

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
public class VideoResource extends APIResource {

    private String baseUrl;

    public Optional<Video> video(String id) {
        try {
            return Optional.ofNullable(rest().getForObject(String.format("%s/videos/%s", baseUrl, id), Video.class));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public List<Video> videos(String channel) {
        Optional<VideosResponse> responseWrapper = null;
        try {
            responseWrapper = Optional.of(rest().getForObject(String.format("%s/channels/%s/videos", baseUrl, channel), VideosResponse.class));
        } catch (Exception excepton) {
            responseWrapper = Optional.empty();
        }

        if (responseWrapper.isPresent()) {
            return responseWrapper.get().getVideos();
        } else {
            return new ArrayList<>();
        }
    }

    public VideoResource url(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

}
