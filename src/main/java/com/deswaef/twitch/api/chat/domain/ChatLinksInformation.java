package com.deswaef.twitch.api.chat.domain;


import com.google.gson.annotations.SerializedName;

/**
 * User: Quinten
 * Date: 23-9-2014
 * Time: 14:33
 *
 * @author Quinten De Swaef
 */
public class ChatLinksInformation {

    @SerializedName("emoticons")
    private String emoticonsUrl;
    @SerializedName("badges")
    private String badgesUrl;

    public String getEmoticonsUrl() {
        return emoticonsUrl;
    }

    public void setEmoticonsUrl(String emoticonsUrl) {
        this.emoticonsUrl = emoticonsUrl;
    }

    public String getBadgesUrl() {
        return badgesUrl;
    }

    public void setBadgesUrl(String badgesUrl) {
        this.badgesUrl = badgesUrl;
    }
}
