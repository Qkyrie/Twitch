package com.deswaef.twitch.api.games.domain;

/**
 * User: Quinten
 * Date: 24-9-2014
 * Time: 13:21
 *
 * @author Quinten De Swaef
 */
public class GameTopResult {

    private Game game;
    private Long viewers;
    private Long channels;


    public Long getViewers() {
        return viewers;
    }

    public void setViewers(Long viewers) {
        this.viewers = viewers;
    }

    public Long getChannels() {
        return channels;
    }

    public void setChannels(Long channels) {
        this.channels = channels;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
