package com.deswaef.twitch.api.chat.domain;

import java.util.List;

/**
 * User: Quinten
 * Date: 24-9-2014
 * Time: 12:11
 *
 * @author Quinten De Swaef
 */
public class ChatEmoticonsInformation {

    private List<ChatEmoticon> emoticons;

    public List<ChatEmoticon> getEmoticons() {
        return emoticons;
    }

    public void setEmoticons(List<ChatEmoticon> emoticons) {
        this.emoticons = emoticons;
    }

}
