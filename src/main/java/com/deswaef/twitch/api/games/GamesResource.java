package com.deswaef.twitch.api.games;

import com.deswaef.twitch.api.games.domain.GameTopResultWrapper;
import retrofit.RestAdapter;

import java.util.Optional;

/**
 * User: Quinten
 * Date: 24-9-2014
 * Time: 12:35
 *
 * @author Quinten De Swaef
 */
public class GamesResource  {

    private GamesService gamesService;

    public Optional<GameTopResultWrapper> top() {
        try {
            return Optional.ofNullable(gamesService.top());
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public GamesResource url(RestAdapter restAdapter) {
        this.gamesService = restAdapter.create(GamesService.class);
        return this;
    }

}
