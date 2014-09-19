package com.deswaef.twitch.api.streams.domain;

import com.deswaef.twitch.api.streams.domain.TwitchStream;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User: Quinten
 * Date: 22-8-2014
 * Time: 21:48
 *
 * @author Quinten De Swaef
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
