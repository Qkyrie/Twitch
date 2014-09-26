package com.deswaef.twitch.api.games;

import com.deswaef.twitch.api.games.domain.GameTopResultWrapper;
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
    public void validateValues(){
        GameTopResultWrapper gameResponse = gamesResource.top().get();
        assertThat(gameResponse.getTop().size()).isEqualTo(10);
    }

}