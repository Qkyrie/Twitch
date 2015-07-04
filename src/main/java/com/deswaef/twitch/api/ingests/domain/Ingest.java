package com.deswaef.twitch.api.ingests.domain;

import com.google.gson.annotations.SerializedName;

/**
 * User: Quinten
 * Date: 28-9-2014
 * Time: 23:47
 *
 * @author Quinten De Swaef
 */
public class Ingest {
    private String name;
    private Integer availability;
    @SerializedName("_id")
    private Long id;
    @SerializedName("default")
    private Boolean byDefault;
    @SerializedName("url_template")
    private String urlTemplate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getByDefault() {
        return byDefault;
    }

    public void setByDefault(Boolean byDefault) {
        this.byDefault = byDefault;
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

    public void setUrlTemplate(String urlTemplate) {
        this.urlTemplate = urlTemplate;
    }
}
