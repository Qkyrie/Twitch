package com.deswaef.twitch.work;

import org.junit.Before;
import org.junit.Test;

import static com.deswaef.twitch.util.TwitchTestHelper.assertThrows;
import static org.fest.assertions.Assertions.assertThat;

public class StreamCheckerTest {
    private StreamChecker streamChecker;

    @Before
    public void init() {
        streamChecker = new StreamChecker();
    }

    @Test
    public void whenStreamsAndBaseUrlNullThrowsError(){
        assertThrows(IllegalArgumentException.class,
                () -> streamChecker.streams()
        );
    }

    @Test
    public void whenStreamsThenReturnsTop25() {
        streamChecker.url("https://api.twitch.tv/kraken");
        assertThat(streamChecker.streams().stream().count()).isEqualTo(25);
    }
}