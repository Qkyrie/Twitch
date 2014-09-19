package com.deswaef.twitch.api.streams.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: Quinten
 * Date: 22-8-2014
 * Time: 20:51
 *
 * @author Quinten De Swaef
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchStream {

    @JsonProperty(value = "_id")
    private Long id;

    private String game;
    private Long viewers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Long getViewers() {
        return viewers;
    }

    public void setViewers(Long viewers) {
        this.viewers = viewers;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", viewers=" + viewers +
                '}';
    }
}
