package com.deswaef.twitch.api.chat;

import com.deswaef.twitch.api.chat.domain.ChatInformation;
import com.deswaef.twitch.api.chat.domain.ChatLinksInformation;
import org.junit.Test;

import java.util.Optional;

import static org.fest.assertions.Assertions.assertThat;

public class ChatResourceTest {

    private ChatResource resource;

    @Test
    public void getValidChatResource() {
        resource = new ChatResource().url("https://api.twitch.tv/kraken");
        Optional<ChatLinksInformation> streamingforanimals = resource.getChatUser("streamingforanimals");
        assertThat(streamingforanimals.isPresent()).isTrue();
    }

    @Test
    public void chatInformationIsMappedCorrectly(){
        resource = new ChatResource().url("https://api.twitch.tv/kraken");
        Optional<ChatLinksInformation> streamingforanimals = resource.getChatUser("streamingforanimals");
        assertThat(streamingforanimals.get().getBadgesUrl()).isEqualTo("https://api.twitch.tv/kraken/chat/streamingforanimals/badges");
        assertThat(streamingforanimals.get().getEmoticonsUrl()).isEqualTo("https://api.twitch.tv/kraken/chat/streamingforanimals/emoticons");
    }

    @Test
    public void getUnexistingOne(){
        resource = new ChatResource().url("https://api.twitch.tv/kraken");
        Optional<ChatLinksInformation> shouldntExist = resource.getChatUser("shouldntExist...");
        assertThat(shouldntExist.isPresent()).isFalse();
    }

}