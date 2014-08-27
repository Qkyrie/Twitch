package com.qkyrie.twitch.work;

import com.qkyrie.twitch.domain.StreamCheck;
import com.qkyrie.twitch.domain.Streams;
import com.qkyrie.twitch.domain.TwitchStream;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

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
public class StreamChecker {
    private String baseUrl;

    /**
     * returns a list of the current top streams
     *
     * @return
     */
    public List<TwitchStream> streams() {
        Assert.notNull(baseUrl, "base url for twitch must be set");
        RestTemplate template = new RestTemplate();
        return Arrays.asList(
                template.getForObject
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
     * @param stream
     * @return
     */
    public Optional<StreamCheck> stream(String stream) {
        Assert.notNull(baseUrl, "base url for twitch must be set");
        try {
            RestTemplate template = new RestTemplate();
            return Optional.of(template.getForObject(String.format("%s/streams/%s", baseUrl, stream), StreamCheck.class));
        } catch (HttpClientErrorException exception) {
            return Optional.empty();
        }
    }

    public StreamChecker url(String url) {
        this.baseUrl = url;
        return this;
    }

}
