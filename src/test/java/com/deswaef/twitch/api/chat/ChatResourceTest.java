package com.deswaef.twitch.api.chat;

import com.deswaef.twitch.api.chat.domain.ChatLinksInformation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import retrofit.RestAdapter;

import java.util.Optional;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ChatResourceTest {

    private ChatResource resource;

    private RestAdapter restAdapter;

    @Mock
    private ChatService chatService;

    @Before
    public void init() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.twitch.tv/kraken")
                .build();
        resource = new ChatResource().url(restAdapter);
    }

    @Test
    public void getValidChatResource() {
        Optional<ChatLinksInformation> streamingforanimals = resource.chatUser("streamingforanimals");
        assertThat(streamingforanimals.isPresent()).isTrue();
    }

    @Test
    public void chatInformationIsMappedCorrectly(){
        Optional<ChatLinksInformation> streamingforanimals = resource.chatUser("streamingforanimals");
        assertThat(streamingforanimals.get().getBadgesUrl()).isEqualTo("https://api.twitch.tv/kraken/chat/streamingforanimals/badges");
        assertThat(streamingforanimals.get().getEmoticonsUrl()).isEqualTo("https://api.twitch.tv/kraken/chat/streamingforanimals/emoticons");
    }

    @Test
    public void getUnexistingOne(){
        Optional<ChatLinksInformation> shouldntExist = resource.chatUser("shouldntExist...");
        assertThat(shouldntExist.isPresent()).isFalse();
    }

    @Test
    public void getUnexistingEmoticons() {
        assertThat(resource.emoticons("shouldntExist...")).isEmpty();
    }

    @Test
    public void getExistingOnes() {
        assertThat(resource.emoticons("streamingforanimals")).isNotEmpty();
    }

}