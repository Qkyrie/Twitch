package com.deswaef.twitch.api.games;

import com.deswaef.twitch.api.games.domain.Game;
import com.deswaef.twitch.api.games.domain.GameImage;
import com.deswaef.twitch.api.games.domain.GameTopResult;
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
        assertThat(game.getGiantbombId()).isGreaterThan(0);
        assertThat(game.getId()).isGreaterThan(0);
    }
}