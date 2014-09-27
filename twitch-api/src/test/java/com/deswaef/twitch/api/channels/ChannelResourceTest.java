package com.deswaef.twitch.api.channels;


import com.deswaef.twitch.api.channels.ChannelResource;
import com.deswaef.twitch.api.channels.domain.TwitchChannel;
import net.vidageek.mirror.dsl.Mirror;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static com.deswaef.twitch.util.ThrowableAssertion.assertThrown;
import static org.fest.assertions.Assertions.assertThat;

public class ChannelResourceTest {
    public static final String BASE_URL = "BASE_URL";
    private ChannelResource channelResource;

    @Before
    public void init(){
        channelResource = new ChannelResource();
    }

    @Test
    public void initializedAndUrlIsSet() {
        channelResource.url(BASE_URL);
        assertThat(new Mirror().on(channelResource).get().field("baseUrl")).isEqualTo(BASE_URL);
    }

    @Test
    public void channelAndNoBaseUrlSet() {
        assertThrown(
                () -> channelResource.channel("streamingforanimals")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void verifyExistingChannel(){
        final ChannelResource newChannelResource = channelResource.url("https://api.twitch.tv/kraken");
        Optional<TwitchChannel> streamingforanimals = newChannelResource.channel("streamingforanimals");
        assertThat(streamingforanimals.isPresent())
                .isTrue();
    }


    @Test
    public void verifyChannelHasCorrectFields(){
        final ChannelResource newChannelResource = channelResource.url("https://api.twitch.tv/kraken");
        Optional<TwitchChannel> streamingforanimals = newChannelResource.channel("streamingforanimals");
        assertThat(streamingforanimals.get().getDisplay_name()).isEqualTo("StreamingForAnimals");
        assertThat(streamingforanimals.get().getStatus()).isNotEmpty();
        assertThat(streamingforanimals.get().getCreatedAt()).isNotNull();
        assertThat(streamingforanimals.get().getUpdatedAt()).isNotNull();
        assertThat(streamingforanimals.get().getUrl()).isEqualTo("http://www.twitch.tv/streamingforanimals");
    }


    @Test
    public void verifyUnexistingChannel(){
        final ChannelResource newChannelResource = channelResource.url("https://api.twitch.tv/kraken");
        assertThat(newChannelResource.channel(String.format("thisoneshouldnotexist_xxx_%s", System.currentTimeMillis())).isPresent())
                .isFalse();
    }

}