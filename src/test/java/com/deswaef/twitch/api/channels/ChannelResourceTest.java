package com.deswaef.twitch.api.channels;


import com.deswaef.twitch.api.channels.domain.TwitchChannel;
import net.vidageek.mirror.dsl.Mirror;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import java.util.Optional;

import static com.deswaef.twitch.util.ThrowableAssertion.assertThrown;
import static org.fest.assertions.Assertions.assertThat;

public class ChannelResourceTest {
    public static final String BASE_URL = "BASE_URL";
    private ChannelResource channelResource;

    private RestAdapter restAdapter;

    @Before
    public void init(){
        restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.twitch.tv/kraken")
                .build();
        channelResource = new ChannelResource().url(restAdapter);
    }

    @Test
    public void initializedAndUrlIsSet() {
        assertThat(new Mirror().on(channelResource).get().field("channelService")).isNotNull();
    }

    @Test
    public void verifyExistingChannel(){
        Optional<TwitchChannel> streamingforanimals = channelResource.channel("streamingforanimals");
        assertThat(streamingforanimals.isPresent())
                .isTrue();
    }


    @Test
    public void verifyChannelHasCorrectFields(){
        Optional<TwitchChannel> streamingforanimals = channelResource.channel("streamingforanimals");
        assertThat(streamingforanimals.get().getDisplay_name()).isEqualTo("StreamingForAnimals");
        assertThat(streamingforanimals.get().getStatus()).isNotEmpty();
        assertThat(streamingforanimals.get().getCreatedAt()).isNotNull();
        assertThat(streamingforanimals.get().getUpdatedAt()).isNotNull();
        assertThat(streamingforanimals.get().getUrl()).isEqualTo("http://www.twitch.tv/streamingforanimals");
    }


    @Test
    public void verifyUnexistingChannel(){
        assertThat(channelResource.channel(String.format("thisoneshouldnotexist_xxx_%s", System.currentTimeMillis())).isPresent())
                .isFalse();
    }

}