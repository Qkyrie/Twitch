package com.deswaef.twitch.api.streams;

import com.deswaef.twitch.api.streams.StreamResource;
import org.junit.Before;
import org.junit.Test;

import static com.deswaef.twitch.util.ThrowableAssertion.assertThrown;
import static org.fest.assertions.Assertions.assertThat;

public class StreamResourceTest {
    private StreamResource streamResource;

    @Before
    public void init() {
        streamResource = new StreamResource();
    }

    @Test
    public void whenStreamsAndBaseUrlNullThrowsError() {
        assertThrown(() -> streamResource.streams()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenStreamsThenReturnsTop25() {
        streamResource.url("https://api.twitch.tv/kraken");
        assertThat(streamResource.streams().stream().count()).isEqualTo(25);
    }
}