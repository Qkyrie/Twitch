package com.deswaef.twitch.api.games.domain;

/**
 * User: Quinten
 * Date: 26-9-2014
 * Time: 17:46
 *
 * @author Quinten De Swaef
 */
public class GameImage {

    private String large;
    private String medium;
    private String small;
    private String template;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
