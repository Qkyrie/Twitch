package com.deswaef.twitch.api.chat;

import com.deswaef.twitch.api.APIResource;
import com.deswaef.twitch.api.chat.domain.ChatEmoticon;
import com.deswaef.twitch.api.chat.domain.ChatEmoticonsInformation;
import com.deswaef.twitch.api.chat.domain.ChatInformation;
import com.deswaef.twitch.api.chat.domain.ChatLinksInformation;
import com.deswaef.twitch.rest.RestTemplateProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * User: Quinten
 * Date: 19-9-2014
 * Time: 14:44
 *
 * @author Quinten De Swaef
 */
public class ChatResource extends APIResource {
    private String baseUrl;

    public ChatResource() {
        super();
    }

    public ChatResource(RestTemplateProvider rtProvider) {
        super(rtProvider);
    }

    public Optional<ChatLinksInformation> chatUser(String chatUser) {
        try {
            return Optional.ofNullable(rest().getForObject(baseUrl + "/chat/" + chatUser, ChatInformation.class).getChatLinksInformation());
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public List<ChatEmoticon> emoticons(String chatUser) {
        try {
            ChatEmoticonsInformation forObject = rest().getForObject(String.format("%s/chat/%s/emoticons", baseUrl, chatUser), ChatEmoticonsInformation.class);
            if(forObject != null && forObject.getEmoticons() != null) {
                return Collections.unmodifiableList(forObject.getEmoticons());
            } else {
                return new ArrayList<>();
            }
        } catch(Exception ex) {
            return new ArrayList<>();
        }
    }

    public ChatResource url(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }
}
