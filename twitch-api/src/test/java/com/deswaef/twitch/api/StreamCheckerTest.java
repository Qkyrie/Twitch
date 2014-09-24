package com.deswaef.twitch.api;

import com.deswaef.twitch.api.streams.StreamChecker;
import org.junit.Before;
import org.junit.Test;

import static com.deswaef.twitch.util.ThrowableAssertion.assertThrown;
import static org.fest.assertions.Assertions.assertThat;

public class StreamCheckerTest {
    private StreamChecker streamChecker;

    @Before
    public void init() {
        streamChecker = new StreamChecker();
    }

    @Test
    public void whenStreamsAndBaseUrlNullThrowsError() {
        assertThrown(() -> streamChecker.streams()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenStreamsThenReturnsTop25() {
        streamChecker.url("https://api.twitch.tv/kraken");
        assertThat(streamChecker.streams().stream().count()).isEqualTo(25);
    }
}