package com.deswaef.twitch.api;

import com.deswaef.twitch.rest.RestTemplateProvider;
import org.springframework.web.client.RestTemplate;

/**
 * User: Quinten
 * Date: 19-9-2014
 * Time: 11:12
 *
 * @author Quinten De Swaef
 */
public class APIResource {
    private final RestTemplateProvider rtProvider;


    public APIResource() {
        this.rtProvider = null;
    }

    public APIResource(RestTemplateProvider rtProvider) {
        this.rtProvider = rtProvider;
    }

    public RestTemplate rest() {
        if(rtProvider == null) {
            return new RestTemplate();
        } else {
            return rtProvider.rest();
        }
    }
}
