package com.deswaef.twitch.api.streams;

import com.deswaef.twitch.api.streams.domain.StreamCheck;
import com.deswaef.twitch.api.streams.domain.TwitchStream;
import com.deswaef.twitch.exception.Assert;
import retrofit.RestAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * User: Quinten
 * Date: 22-8-2014
 * Time: 20:47
 *
 * @author Quinten De Swaef
 */
public class StreamResource  {

    private StreamService streamService;

    /**
     * returns a list of the current top streams
     *
     * @return List of TwitchStream
     */
    public List<TwitchStream> streams() {
        try {
            return Arrays.asList(
                    streamService.streams()
                            .getStreams());
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    /**
     * Returns an Optional of Streamcheck.
     * If the stream does not exist, the optional is empty.
     * Otherwise, utility methods in the StreamCheck will tell you if the stream is online or not.
     *
     * @param stream String name of the stream
     * @return Optional of StreamCheck
     */
    public Optional<StreamCheck> stream(String stream) {
        Assert.notNull(stream, "url for stream must not be null");
        try {
            return Optional.of(streamService.stream(stream));
        } catch (Exception exception) {
            return Optional.empty();
        }
    }

    public StreamResource url(RestAdapter restAdapter) {
        this.streamService = restAdapter.create(StreamService.class);
        return this;
    }

}
