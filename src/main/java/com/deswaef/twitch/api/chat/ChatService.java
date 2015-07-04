package com.deswaef.twitch.api.chat;

import com.deswaef.twitch.api.chat.domain.ChatEmoticonsInformation;
import com.deswaef.twitch.api.chat.domain.ChatInformation;
import com.deswaef.twitch.api.chat.domain.ChatLinksInformation;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * User: Quinten
 * Date: 5-7-2015
 * Time: 01:11
 *
 * @author Quinten De Swaef
 */
public interface ChatService {

    @GET("/chat/{chatUser}")
    ChatInformation chatUser(@Path("chatUser")String chatUser);

    @GET("/chat/{chatUser}/emoticons")
    ChatEmoticonsInformation emoticons(@Path("chatUser") String chatUser);
}
