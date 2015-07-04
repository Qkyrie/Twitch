package com.deswaef.twitch.api.oauth.domain;

/**
 * User: Quinten
 * Date: 16-9-2014
 * Time: 16:34
 *
 * @author Quinten De Swaef
 */
public class AccessTokenRequest {

    private String client_id;
    private String client_secret;
    private String grant_type = "authorization_code";
    private String redirect_uri;
    private String code;

    public AccessTokenRequest copy(String code) {
        return new AccessTokenRequest()
                .setClient_secret(this.client_secret)
                .setRedirect_uri(this.getRedirect_uri())
                .setClient_id(this.getClient_id())
                .setGrant_type(this.getGrant_type())
                .setCode(code);
    }

    public String getClient_id() {
        return client_id;
    }

    public AccessTokenRequest setClient_id(String client_id) {
        this.client_id = client_id;
        return this;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public AccessTokenRequest setClient_secret(String client_secret) {
        this.client_secret = client_secret;
        return this;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public AccessTokenRequest setGrant_type(String grant_type) {
        this.grant_type = grant_type;
        return this;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public AccessTokenRequest setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AccessTokenRequest setCode(String code) {
        this.code = code;
        return this;
    }
}
