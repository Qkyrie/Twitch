package com.deswaef.twitch.api.games.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * User: Quinten
 * Date: 24-9-2014
 * Time: 12:36
 *
 * @author Quinten De Swaef
 */
public class GameTopResultWrapper {

    @SerializedName("_total")
    private Long total;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @SerializedName("top")
    private List<GameTopResult> top;

    public List<GameTopResult> getTop() {
        return top;
    }

    public void setTop(List<GameTopResult> top) {
        this.top = top;
    }
}
