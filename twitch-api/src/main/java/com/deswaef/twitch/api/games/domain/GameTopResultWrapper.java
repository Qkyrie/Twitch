package com.deswaef.twitch.api.games.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * User: Quinten
 * Date: 24-9-2014
 * Time: 12:36
 *
 * @author Quinten De Swaef
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameTopResultWrapper {

    @JsonProperty("top")
    private List<GameTopResult> top;

    public List<GameTopResult> getTop() {
        return top;
    }

    public void setTop(List<GameTopResult> top) {
        this.top = top;
    }
}
