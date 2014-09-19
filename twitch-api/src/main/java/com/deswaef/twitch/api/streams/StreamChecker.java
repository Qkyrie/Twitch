package com.deswaef.twitch.api.streams;

import com.deswaef.twitch.api.APIResource;
import com.deswaef.twitch.api.streams.domain.StreamCheck;
import com.deswaef.twitch.api.streams.domain.Streams;
import com.deswaef.twitch.api.streams.domain.TwitchStream;
import com.deswaef.twitch.rest.RestTemplateProvider;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;

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
public class StreamChecker extends APIResource {
    private String baseUrl;


    public StreamChecker() {
        super();
    }

    public StreamChecker(RestTemplateProvider provider) {
        super(provider);
    }

    /**
     * returns a list of the current top streams
     *
     * @return List of TwitchStream
     */
    public List<TwitchStream> streams() {
        Assert.notNull(baseUrl, "base url for twitch must be set");
        return Arrays.asList(
                rest().getForObject
                        (
                            String.format("%s/streams", baseUrl),
                            Streams.class
                        )
                        .getStreams());
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
        Assert.notNull(baseUrl, "base url for twitch must be set");
        try {
            return Optional.of(rest().getForObject(String.format("%s/streams/%s", baseUrl, stream), StreamCheck.class));
        } catch (HttpClientErrorException exception) {
            return Optional.empty();
        }
    }

    public StreamChecker url(String url) {
        this.baseUrl = url;
        return this;
    }

}
