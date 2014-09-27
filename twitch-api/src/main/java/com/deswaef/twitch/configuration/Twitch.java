package com.deswaef.twitch.configuration;

import com.deswaef.twitch.api.channels.ChannelResource;
import com.deswaef.twitch.api.oauth.AccessTokenResource;
import com.deswaef.twitch.api.user.AuthenticatedUserResource;
import com.deswaef.twitch.rest.RestTemplateProvider;
import com.deswaef.twitch.api.streams.StreamResource;

public class Twitch {

    private StreamResource streams;
    private ChannelResource channels;
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
                .streams(new StreamResource(provider))
                .channels(new ChannelResource(provider))
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
    public StreamResource streams() {
        return streams;
    }
    public ChannelResource channels() {
        return channels;
    }
    public AuthenticatedUserResource user() {
        return authenticatedUserResource;
    }

    public Twitch streams(StreamResource streamResource) {
        this.streams = streamResource.url(this.url);
        return this;
    }

    public Twitch channels(ChannelResource channelResource) {
        this.channels = channelResource.url(this.url);
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