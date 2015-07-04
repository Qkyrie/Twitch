package com.deswaef.twitch.api.games;

import com.deswaef.twitch.api.games.domain.Game;
import com.deswaef.twitch.api.games.domain.GameImage;
import com.deswaef.twitch.api.games.domain.GameTopResult;
import net.vidageek.mirror.dsl.Mirror;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class GamesResourceTest {

    public static final String API_URL = "https://api.twitch.tv/kraken";
    private GamesResource gamesResource;

    @Before
    public void init() {
        gamesResource = new GamesResource().url("https://api.twitch.tv/kraken");
    }

    @Test
    public void initializedAndUrlIsSet() {
        assertThat(new Mirror().on(gamesResource).get().field("baseUrl")).isEqualTo(API_URL);
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

    @Test
    public void topHasValidGames() {
        gamesResource.top().get().getTop().stream()
                .map(x -> x.getGame())
                .forEach(
                        this::validateGame
                );
    }

    @Test
    public void topHasValidGameLogos(){
        gamesResource.top().get().getTop().stream()
                .map(x -> x.getGame().getLogo())
                .forEach(
                        this::validateImage
                );
    }

    @Test
    public void topHasValidBox(){
        gamesResource.top().get().getTop().stream()
                .map(x -> x.getGame().getBox())
                .forEach(
                        this::validateImage
                );
    }

    private void validateImage(GameImage gameImage) {
        assertThat(gameImage.getLarge()).isNotEmpty();
        assertThat(gameImage.getMedium()).isNotEmpty();
        assertThat(gameImage.getSmall()).isNotEmpty();
        assertThat(gameImage.getTemplate()).isNotEmpty();
    }


    private void validateGame(Game game) {
        assertThat(game.getId()).isGreaterThan(0);
    }
}