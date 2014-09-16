package com.deswaef.twitch.work;


import org.junit.Before;
import org.junit.Test;

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
        assertThat(newChannelChecker.channel("streamingforanimals").isPresent())
                .isTrue();
    }

    @Test
    public void verifyUnexistingChannel(){
        final ChannelChecker newChannelChecker = channelChecker.url("https://api.twitch.tv/kraken");
        assertThat(newChannelChecker.channel(String.format("thisoneshouldnotexist_xxx_%s", System.currentTimeMillis())).isPresent())
                .isFalse();
    }

}