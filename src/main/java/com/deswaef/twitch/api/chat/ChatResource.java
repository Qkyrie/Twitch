package com.deswaef.twitch.api.chat;

import com.deswaef.twitch.api.chat.domain.ChatEmoticon;
import com.deswaef.twitch.api.chat.domain.ChatEmoticonsInformation;
import com.deswaef.twitch.api.chat.domain.ChatInformation;
import com.deswaef.twitch.api.chat.domain.ChatLinksInformation;
import retrofit.RestAdapter;

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
public class ChatResource {

    private ChatService chatService;


    public ChatResource() {
        super();
    }


    public Optional<ChatLinksInformation> chatUser(String chatUser) {
        try {
            return Optional.ofNullable(chatService.chatUser(chatUser).getChatLinksInformation());
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public List<ChatEmoticon> emoticons(String chatUser) {
        try {
            ChatEmoticonsInformation forObject = chatService.emoticons(chatUser);
            if (forObject != null && forObject.getEmoticons() != null) {
                return Collections.unmodifiableList(forObject.getEmoticons());
            } else {
                return new ArrayList<>();
            }
        } catch(Exception ex) {
            return new ArrayList<>();
        }
    }

    public ChatResource url(RestAdapter restAdapter) {
        this.chatService = restAdapter.create(ChatService.class);
        return this;
    }
}
