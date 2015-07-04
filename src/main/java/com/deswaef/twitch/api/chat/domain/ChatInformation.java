package com.deswaef.twitch.api.chat.domain;


import com.google.gson.annotations.SerializedName;

/**
 * User: Quinten
 * Date: 23-9-2014
 * Time: 14:04
 *
 * @author Quinten De Swaef
 */
public class ChatInformation {

    @SerializedName("_links")
    private ChatLinksInformation chatLinksInformation;

    public ChatLinksInformation getChatLinksInformation() {
        return chatLinksInformation;
    }

    public void setChatLinksInformation(ChatLinksInformation chatLinksInformation) {
        this.chatLinksInformation = chatLinksInformation;
    }
}
