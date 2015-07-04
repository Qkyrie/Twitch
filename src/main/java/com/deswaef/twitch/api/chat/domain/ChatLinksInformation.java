package com.deswaef.twitch.api.chat.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: Quinten
 * Date: 23-9-2014
 * Time: 14:33
 *
 * @author Quinten De Swaef
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatLinksInformation {

    @JsonProperty("emoticons")
    private String emoticonsUrl;
    @JsonProperty("badges")
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
