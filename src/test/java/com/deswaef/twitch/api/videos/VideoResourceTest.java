package com.deswaef.twitch.api.videos;

import com.deswaef.twitch.api.videos.domain.Video;
import net.vidageek.mirror.dsl.Mirror;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.NON_EXISTENT;
import retrofit.RestAdapter;

import java.util.Optional;

import static org.fest.assertions.Assertions.assertThat;

public class VideoResourceTest {

    public static final String API_URL = "https://api.twitch.tv/kraken";
    public static final String CHANNEL_WITH_VIDEOS = "dafkej";
    public static final String UNEXISTING_CHANNEL = "unexisting_channel_xxx";
    public static final String EXISTING_VIDEO_ID = "c2990387";
    private VideoResource videoResource;

    private RestAdapter restAdapter;

    @Before
    public void init() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.twitch.tv/kraken")
                .build();
        videoResource = new VideoResource().url(restAdapter);
    }

    @Test
    public void initializedAndUrlIsSet() {
        assertThat(new Mirror().on(videoResource).get().field("videoService")).isNotNull();
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

    @Test
    public void existingVideoHasCorrectFields(){
        Optional<Video> video = videoResource.video(EXISTING_VIDEO_ID);
        video.ifPresent(
                this::validateVideo
        );
        video.orElseThrow(() -> new IllegalArgumentException("no video found"));
    }

    @Test
    public void nonExistingVideoIsEmptyOptional() {
        assertThat(videoResource.video(UNEXISTING_CHANNEL).isPresent()).isFalse();
    }

    @Test
    public void unexistingChannelReturnsNoVideos() {
        assertThat(videoResource.videos(UNEXISTING_CHANNEL)).isEmpty();
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
        assertThat(video.getRecordedAt()).isNotNull();
    }

}