package com.deswaef.twitch.api.games;

import com.deswaef.twitch.api.games.domain.GameTopResultWrapper;
import retrofit.http.GET;

/**
 * User: Quinten
 * Date: 5-7-2015
 * Time: 00:33
 *
 * @author Quinten De Swaef
 */
public interface GamesService {
    @GET("/games/top")
    public GameTopResultWrapper top();
}
