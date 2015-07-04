package com.deswaef.twitch.api.streams.domain;

import java.util.Arrays;

/**
 * User: Quinten
 * Date: 22-8-2014
 * Time: 21:32
 *
 * @author Quinten De Swaef
 */
public class Streams {
    private TwitchStream[] streams;

    public TwitchStream[] getStreams() {
        return streams;
    }

    public void setStreams(TwitchStream[] streams) {
        this.streams = streams;
    }

    @Override
    public String toString() {
        return "Streams{" +
                "streams=" + Arrays.toString(streams) +
                '}';
    }
}
