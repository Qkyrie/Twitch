package com.deswaef.twitch.configuration;

import com.deswaef.twitch.api.channels.ChannelResource;
import com.deswaef.twitch.api.oauth.AccessTokenResource;
import com.deswaef.twitch.api.user.UserResource;
import com.deswaef.twitch.api.streams.StreamResource;
import retrofit.RestAdapter;

public class Twitch {

    private StreamResource streams;
    private ChannelResource channels;
    private AccessTokenResource accessTokenResource;
    private UserResource userResource;

    private String url;
    private RestAdapter restAdapter;

    private Twitch() {}

    public static final Twitch newTwitchInstance(
            String baseUrl,
            String clientId,
            String clientSecret,
            String redirectUrl
    ) {
        return new Twitch()
                .url(createRestAdaptor(baseUrl))
                .streams(new StreamResource())
                .channels(new ChannelResource())
                .accessTokens(new AccessTokenResource()
                        .setClientId(clientId)
                        .setClientSecret(clientSecret)
                        .setRedirectUrl(redirectUrl))
                .user(new UserResource());
    }

    private static RestAdapter createRestAdaptor(String baseUrl) {
        return new RestAdapter
                .Builder()
                .setEndpoint(baseUrl)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    private Twitch accessTokens(AccessTokenResource accessTokenResource) {
        this.accessTokenResource = accessTokenResource.setBaseUrl(restAdapter);
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
    public UserResource user() {
        return userResource;
    }

    public Twitch streams(StreamResource streamResource) {
        this.streams = streamResource.url(restAdapter);
        return this;
    }

    public Twitch channels(ChannelResource channelResource) {
        this.channels = channelResource.url(restAdapter);
        return this;
    }

    public Twitch user(UserResource userResource) {
        this.userResource = userResource.url(restAdapter);
        return this;
    }

    public Twitch url(RestAdapter restAdapter) {
        this.restAdapter = restAdapter;
        return this;
    }
}