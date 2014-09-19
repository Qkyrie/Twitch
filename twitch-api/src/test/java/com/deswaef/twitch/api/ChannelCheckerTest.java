package com.deswaef.twitch.api;


import com.deswaef.twitch.api.channels.domain.TwitchChannel;
import com.deswaef.twitch.api.channels.ChannelChecker;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static com.deswaef.twitch.util.TwitchTestHelper.assertThrows;
import static org.fest.assertions.Assertions.assertThat;

public class ChannelCheckerTest {
    private ChannelChecker channelChecker;

    @Before
    public void init(){
        channelChecker = new ChannelChecker();
    }

    @Test
    public void channelAndNoBaseUrlSet() {
        assertThrows(
                IllegalArgumentException.class,
                () -> channelChecker.channel("streamingforanimals"));
    }

    @Test
    public void verifyExistingChannel(){
        final ChannelChecker newChannelChecker = channelChecker.url("https://api.twitch.tv/kraken");
        Optional<TwitchChannel> streamingforanimals = newChannelChecker.channel("streamingforanimals");
        assertThat(streamingforanimals.isPresent())
                .isTrue();
    }


    @Test
    public void verifyChannelHasCorrectFields(){
        final ChannelChecker newChannelChecker = channelChecker.url("https://api.twitch.tv/kraken");
        Optional<TwitchChannel> streamingforanimals = newChannelChecker.channel("streamingforanimals");
        assertThat(streamingforanimals.get().getDisplay_name()).isEqualTo("StreamingForAnimals");
        assertThat(streamingforanimals.get().getStatus()).isNotEmpty();
        assertThat(streamingforanimals.get().getCreatedAt()).isNotNull();
        assertThat(streamingforanimals.get().getUpdatedAt()).isNotNull();
        assertThat(streamingforanimals.get().getUrl()).isEqualTo("http://www.twitch.tv/streamingforanimals");
    }


    @Test
    public void verifyUnexistingChannel(){
        final ChannelChecker newChannelChecker = channelChecker.url("https://api.twitch.tv/kraken");
        assertThat(newChannelChecker.channel(String.format("thisoneshouldnotexist_xxx_%s", System.currentTimeMillis())).isPresent())
                .isFalse();
    }

}