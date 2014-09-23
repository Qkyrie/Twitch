package com.deswaef.twitch.api.chat;

import com.deswaef.twitch.api.APIResource;
import com.deswaef.twitch.api.chat.domain.ChatInformation;
import com.deswaef.twitch.api.chat.domain.ChatLinksInformation;
import com.deswaef.twitch.rest.RestTemplateProvider;

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

    public Optional<ChatLinksInformation> getChatUser(String chatUser) {
        try {
            return Optional.ofNullable(rest().getForObject(baseUrl + "/chat/" + chatUser, ChatInformation.class).getChatLinksInformation());
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public ChatResource url(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }
}
