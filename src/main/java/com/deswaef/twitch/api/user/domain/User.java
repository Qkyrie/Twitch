package com.deswaef.twitch.api.user.domain;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * User: Quinten
 * Date: 16-9-2014
 * Time: 22:20
 *
 * @author Quinten De Swaef
 */
public class User {

    private String name;
    @SerializedName(value = "created_at")
    private Date createdAt;
    @SerializedName(value = "updated_at")
    private Date updatedAt;
    private String logo;
    @SerializedName(value = "_id")
    private Long id;
    private String email;
    @SerializedName("display_name")
    private String displayName;
    private boolean partnered;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isPartnered() {
        return partnered;
    }

    public void setPartnered(boolean partnered) {
        this.partnered = partnered;
    }
}
