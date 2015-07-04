package com.deswaef.twitch.api.streams;

import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import static org.fest.assertions.Assertions.assertThat;

public class StreamResourceTest {
    private StreamResource streamResource;

    private RestAdapter restAdapter;

    @Before
    public void init() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.twitch.tv/kraken")
                .build();
        streamResource = new StreamResource().url(restAdapter);
    }

    @Test
    public void whenStreamsThenReturnsTop25() {
        assertThat(streamResource.streams().stream().count()).isEqualTo(25);
    }
}