package com.qkyrie.twitch.work;

import com.qkyrie.twitch.domain.StreamCheck;
import com.qkyrie.twitch.domain.Streams;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

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

    public Streams streams() {
        RestTemplate template = new RestTemplate();
        return template.getForObject(String.format("%s/streams", baseUrl), Streams.class);
    }

    public Optional<StreamCheck> stream(String stream) {
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
