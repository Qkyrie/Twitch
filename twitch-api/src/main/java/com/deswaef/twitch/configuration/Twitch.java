package com.deswaef.twitch.configuration;

import com.deswaef.twitch.work.ChannelChecker;
import com.deswaef.twitch.work.StreamChecker;

public class Twitch {

    private StreamChecker streams;
    private ChannelChecker channels;

    private String url;

    public StreamChecker streams() {
        return streams;
    }
    public ChannelChecker channels() {
        return channels;
    }

    public Twitch streams(StreamChecker streamChecker) {
        this.streams = streamChecker;
        return this;
    }

    public Twitch channels(ChannelChecker channelChecker) {
        this.channels = channelChecker;
        return this;
    }

    public Twitch url(String url) {
        this.url = url;
        return this;
    }

    public String url() {
        return url;
    }

}