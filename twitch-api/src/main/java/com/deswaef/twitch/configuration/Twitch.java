package com.deswaef.twitch.configuration;

import com.deswaef.twitch.api.oauth.AccessTokenResource;
import com.deswaef.twitch.api.user.AuthenticatedUserResource;
import com.deswaef.twitch.rest.RestTemplateProvider;
import com.deswaef.twitch.api.channels.ChannelChecker;
import com.deswaef.twitch.api.streams.StreamChecker;

public class Twitch {

    private StreamChecker streams;
    private ChannelChecker channels;
    private AccessTokenResource accessTokenResource;
    private AuthenticatedUserResource authenticatedUserResource;

    private String url;

    private Twitch() {}

    public static final Twitch newTwitchInstance(
            String baseUrl,
            String clientId,
            String clientSecret,
            String redirectUrl
    ) {
        RestTemplateProvider provider = new RestTemplateProvider();
        return new Twitch()
                .url(baseUrl)
                .streams(new StreamChecker(provider))
                .channels(new ChannelChecker(provider))
                .accessTokens(new AccessTokenResource(provider)
                        .setClientId(clientId)
                        .setClientSecret(clientSecret)
                        .setRedirectUrl(redirectUrl))
                .user(new AuthenticatedUserResource(provider))
                ;
    }

    private Twitch accessTokens(AccessTokenResource accessTokenResource) {
        this.accessTokenResource = accessTokenResource.setBaseUrl(url);
        return this;
    }

    public AccessTokenResource accessTokens() {
        return accessTokenResource;
    }
    public StreamChecker streams() {
        return streams;
    }
    public ChannelChecker channels() {
        return channels;
    }
    public AuthenticatedUserResource user() {
        return authenticatedUserResource;
    }

    public Twitch streams(StreamChecker streamChecker) {
        this.streams = streamChecker.url(this.url);
        return this;
    }

    public Twitch channels(ChannelChecker channelChecker) {
        this.channels = channelChecker.url(this.url);
        return this;
    }

    public Twitch user(AuthenticatedUserResource authenticatedUserResource) {
        this.authenticatedUserResource = authenticatedUserResource.url(this.url);
        return this;
    }

    public Twitch url(String url) {
        this.url = url;
        return this;
    }
}