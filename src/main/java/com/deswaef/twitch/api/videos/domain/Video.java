package com.deswaef.twitch.api.videos.domain;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * User: Quinten
 * Date: 27-9-2014
 * Time: 01:52
 *
 * @author Quinten De Swaef
 */
public class Video {
    private String title;
    private String description;
    @SerializedName("broadcast_id")
    private Long broadcastId;
    @SerializedName("_id")
    private String id;
    private Long length;
    private String preview;
    private String url;
    private Long views;
    private String game;
    @SerializedName("recorded_at")
    private Date recordedAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBroadcastId() {
        return broadcastId;
    }

    public void setBroadcastId(Long broadcastId) {
        this.broadcastId = broadcastId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Date getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(Date recordedAt) {
        this.recordedAt = recordedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
