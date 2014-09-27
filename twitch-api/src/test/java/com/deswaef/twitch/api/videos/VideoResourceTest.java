package com.deswaef.twitch.api.videos;

import com.deswaef.twitch.api.videos.domain.Video;
import net.vidageek.mirror.dsl.Mirror;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class VideoResourceTest {

    public static final String API_URL = "https://api.twitch.tv/kraken";
    public static final String CHANNEL_WITH_VIDEOS = "dafkej";
    private VideoResource videoResource;

    @Before
    public void init() {
        videoResource = new VideoResource().url(API_URL);
    }

    @Test
    public void initializedAndUrlIsSet() {
        assertThat(new Mirror().on(videoResource).get().field("baseUrl")).isEqualTo(API_URL);
    }

    @Test
    public void videosAndNotEmpty() {
        assertThat(videoResource.videos(CHANNEL_WITH_VIDEOS)).isNotEmpty();
    }

    @Test
    public void validateVideoProperties(){
        videoResource.videos(CHANNEL_WITH_VIDEOS)
                .stream()
                .forEach(this::validateVideo);
    }

    private void validateVideo(Video video) {
        assertThat(video.getId()).isNotEmpty();
        assertThat(video.getBroadcastId()).isGreaterThan(0);
        assertThat(video.getDescription()).isNotEmpty();
        assertThat(video.getPreview()).isNotEmpty();
        assertThat(video.getUrl()).isNotEmpty();
        assertThat(video.getGame()).isNotEmpty();
        assertThat(video.getViews()).isNotNull();
        assertThat(video.getLength()).isGreaterThan(0);
        assertThat(video.getTitle()).isNotEmpty();
    }

}