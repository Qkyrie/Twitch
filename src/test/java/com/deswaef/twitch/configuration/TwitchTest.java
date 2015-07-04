package com.deswaef.twitch.configuration;


import com.deswaef.twitch.api.oauth.domain.AccessTokenRequest;
import net.vidageek.mirror.dsl.Mirror;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TwitchTest {

    public static final String BASE_URL = "https://api.twitch.tv/kraken";
    public static final String CLIENT_ID = "clientId";
    public static final String CLIENT_SECRET = "clientSecret";
    public static final String REDIRECT_URI = "redirectURI";
    public static final String GRANT_TYPE = "authorization_code";

    private Twitch twitch;

    @Before
    public void init(){
        twitch = Twitch.newTwitchInstance(BASE_URL, CLIENT_ID, CLIENT_SECRET, REDIRECT_URI);
    }


    @Test
    public void newHasValidAccessTokenRequestTemplate(){
        AccessTokenRequest requestTemplate = (AccessTokenRequest) new Mirror().on(twitch.accessTokens()).get().field("requestTemplate");
        assertThat(requestTemplate.getClient_id()).isEqualTo(CLIENT_ID);
        assertThat(requestTemplate.getClient_secret()).isEqualTo(CLIENT_SECRET);
        assertThat(requestTemplate.getGrant_type()).isEqualTo(GRANT_TYPE);
        assertThat(requestTemplate.getRedirect_uri()).isEqualTo(REDIRECT_URI);

        //code is specific for every request, and therefore will be null at startup
        assertThat(requestTemplate.getCode()).isNull();
    }


}