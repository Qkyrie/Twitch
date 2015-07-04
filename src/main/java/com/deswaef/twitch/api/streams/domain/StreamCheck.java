package com.deswaef.twitch.api.streams.domain;


/**
 * User: Quinten
 * Date: 22-8-2014
 * Time: 21:48
 *
 * @author Quinten De Swaef
 */
public class StreamCheck {

    private TwitchStream stream;

    public boolean isOnline() {
        return stream != null;
    }

    public TwitchStream getStream() {
        return stream;
    }

    public void setStream(TwitchStream stream) {
        this.stream = stream;
    }
}
