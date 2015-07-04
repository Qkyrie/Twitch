package com.deswaef.twitch.api.channels.domain;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * User: Quinten
 * Date: 22-8-2014
 * Time: 21:42
 *
 * @author Quinten De Swaef
 */
public class TwitchChannel {
    @SerializedName("_id")
    private Long id;
    private String name;
    private String status;
    private String display_name;
    private String game;
    private int delay;
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("updated_at")
    private Date updatedAt;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TwitchChannel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", display_name='" + display_name + '\'' +
                ", game='" + game + '\'' +
                ", delay=" + delay +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", url='" + url + '\'' +
                '}';
    }
}
