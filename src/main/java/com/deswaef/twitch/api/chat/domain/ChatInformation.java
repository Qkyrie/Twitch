package com.deswaef.twitch.api.chat.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: Quinten
 * Date: 23-9-2014
 * Time: 14:04
 *
 * @author Quinten De Swaef
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatInformation {

    @JsonProperty("_links")
    private ChatLinksInformation chatLinksInformation;

    public ChatLinksInformation getChatLinksInformation() {
        return chatLinksInformation;
    }

    public void setChatLinksInformation(ChatLinksInformation chatLinksInformation) {
        this.chatLinksInformation = chatLinksInformation;
    }
}
