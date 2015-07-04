package com.deswaef.twitch.api.games.domain;

import com.google.gson.annotations.SerializedName;

/**
 * User: Quinten
 * Date: 24-9-2014
 * Time: 12:36
 *
 * @author Quinten De Swaef
 */
public class Game {

    @SerializedName("_id")
    private Long id;
    @SerializedName("giantbomb_id")
    private Long giantbombId;
    @SerializedName("box")
    private GameImage box;
    @SerializedName("logo")
    private GameImage logo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGiantbombId() {
        return giantbombId;
    }

    public void setGiantbombId(Long giantbombId) {
        this.giantbombId = giantbombId;
    }

    public GameImage getBox() {
        return box;
    }

    public void setBox(GameImage box) {
        this.box = box;
    }

    public GameImage getLogo() {
        return logo;
    }

    public void setLogo(GameImage logo) {
        this.logo = logo;
    }
}
