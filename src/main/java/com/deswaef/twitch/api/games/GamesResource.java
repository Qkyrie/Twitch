package com.deswaef.twitch.api.games;

import com.deswaef.twitch.api.APIResource;
import com.deswaef.twitch.api.games.domain.GameTopResultWrapper;

import java.util.Optional;

/**
 * User: Quinten
 * Date: 24-9-2014
 * Time: 12:35
 *
 * @author Quinten De Swaef
 */
public class GamesResource extends APIResource {

    private String baseUrl;

    public Optional<GameTopResultWrapper> top() {
        try {
            GameTopResultWrapper forObject = rest().getForObject(baseUrl + "/games/top", GameTopResultWrapper.class);
            return Optional.of(forObject);
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public GamesResource url(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

}
