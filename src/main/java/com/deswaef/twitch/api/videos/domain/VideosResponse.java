package com.deswaef.twitch.api.videos.domain;

import java.util.List;

/**
 * User: Quinten
 * Date: 27-9-2014
 * Time: 01:41
 *
 * @author Quinten De Swaef
 */
public class VideosResponse {
    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
