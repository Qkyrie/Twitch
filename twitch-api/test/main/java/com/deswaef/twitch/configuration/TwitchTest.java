package com.deswaef.twitch.configuration;


import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TwitchTest {

    private Twitch twitch;

    @Test
    public void createNewUsingStaticMethod() {
        twitch = Twitch.newTwitchInstance("https://api.twitch.tv/kraken");
        assertThat(twitch.streams()).isNotNull();
        assertThat(twitch.channels()).isNotNull();
    }

}