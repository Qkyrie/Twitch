package com.deswaef.twitch.api.chat.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: Quinten
 * Date: 24-9-2014
 * Time: 12:13
 *
 * @author Quinten De Swaef
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatEmoticon {
    private String regex;
    private String url;
    private Long height;
    private Long width;
    @JsonProperty("subscriber_only")
    private boolean subscriberOnly;
}
