package com.deswaef.twitch.configuration;

import com.deswaef.twitch.work.AuthorizingUserConnector;
import com.deswaef.twitch.work.ChannelChecker;
import com.deswaef.twitch.work.StreamChecker;
import com.deswaef.twitch.work.oauth.AccessTokenFetcher;

public class Twitch {

    private StreamChecker streams;
    private ChannelChecker channels;
    private AccessTokenFetcher accessTokenFetcher;
    private AuthorizingUserConnector authorizingUserConnector;

    private String url;

    private Twitch() {}

    public static final Twitch newTwitchInstance(
            String baseUrl,
            String clientId,
            String clientSecret,
            String redirectUrl
    ) {
        return new Twitch()
                .url(baseUrl)
                .streams(new StreamChecker())
                .channels(new ChannelChecker())
                .accessTokens(new AccessTokenFetcher()
                        .setClientId(clientId)
                        .setClientSecret(clientSecret)
                        .setRedirectUrl(redirectUrl))
                .user(new AuthorizingUserConnector())
                ;
    }

    private Twitch accessTokens(AccessTokenFetcher accessTokenFetcher) {
        this.accessTokenFetcher = accessTokenFetcher.setBaseUrl(url);
        return this;
    }

    public AccessTokenFetcher accessTokens() {
        return accessTokenFetcher;
    }
    public StreamChecker streams() {
        return streams;
    }
    public ChannelChecker channels() {
        return channels;
    }
    public AuthorizingUserConnector user() {
        return authorizingUserConnector;
    }

    public Twitch streams(StreamChecker streamChecker) {
        this.streams = streamChecker.url(this.url);
        return this;
    }

    public Twitch channels(ChannelChecker channelChecker) {
        this.channels = channelChecker.url(this.url);
        return this;
    }

    public Twitch user(AuthorizingUserConnector authorizingUserConnector) {
        this.authorizingUserConnector = authorizingUserConnector.url(this.url);
        return this;
    }

    public Twitch url(String url) {
        this.url = url;
        return this;
    }
}