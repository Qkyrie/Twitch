package com.deswaef.twitch.api.games;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class GamesResourceTest {

    private GamesResource gamesResource;

    @Before
    public void init() {
        gamesResource = new GamesResource().url("https://api.twitch.tv/kraken");
    }

    @Test
    public void topReturnsResults() {
        assertThat(gamesResource.top().isPresent()).isTrue();
    }

    @Test
    public void topHasTotalInformation() {
        assertThat(gamesResource.top().get().getTotal()).isGreaterThan(0);
    }

    @Test
    public void topHas10GameInfos(){
        assertThat(gamesResource.top().get().getTop().size()).isEqualTo(10);
    }
}