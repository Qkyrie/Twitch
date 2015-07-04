package com.deswaef.twitch.api.chat.domain;


import com.google.gson.annotations.SerializedName;

/**
 * User: Quinten
 * Date: 24-9-2014
 * Time: 12:13
 *
 * @author Quinten De Swaef
 */
public class ChatEmoticon {
    private String regex;
    private String url;
    private Long height;
    private Long width;
    @SerializedName("subscriber_only")
    private boolean subscriberOnly;

    public String getRegex() {
        return regex;
    }

    public ChatEmoticon setRegex(String regex) {
        this.regex = regex;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ChatEmoticon setUrl(String url) {
        this.url = url;
        return this;
    }

    public Long getHeight() {
        return height;
    }

    public ChatEmoticon setHeight(Long height) {
        this.height = height;
        return this;
    }

    public Long getWidth() {
        return width;
    }

    public ChatEmoticon setWidth(Long width) {
        this.width = width;
        return this;
    }

    public boolean isSubscriberOnly() {
        return subscriberOnly;
    }

    public ChatEmoticon setSubscriberOnly(boolean subscriberOnly) {
        this.subscriberOnly = subscriberOnly;
        return this;
    }
}
