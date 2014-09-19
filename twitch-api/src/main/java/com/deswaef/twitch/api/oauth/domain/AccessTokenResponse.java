package com.deswaef.twitch.api.oauth.domain;

/**
 * User: Quinten
 * Date: 16-9-2014
 * Time: 16:34
 *
 * @author Quinten De Swaef
 */
public class AccessTokenResponse {

    private AccessTokenResponseEnum status = AccessTokenResponseEnum.OK;

    public static AccessTokenResponse invalid_code() {
        return new AccessTokenResponse()
                .setStatus(AccessTokenResponseEnum.INVALID_CODE);
    }

    public static AccessTokenResponse forbidden() {
        return new AccessTokenResponse()
                .setStatus(AccessTokenResponseEnum.FORBIDDEN);
    }

    public static AccessTokenResponse unknown_issue() {
        return new AccessTokenResponse()
                .setStatus(AccessTokenResponseEnum.UNKNOWN_ISSUE);
    }



    private String access_token;
    private String refresh_token;
    private String[] scope;

    public String getAccess_token() {
        return access_token;
    }

    public AccessTokenResponse setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public AccessTokenResponse setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public AccessTokenResponseEnum getStatus() {
        return status;
    }

    public AccessTokenResponse setStatus(AccessTokenResponseEnum status) {
        this.status = status;
        return this;
    }

    public String[] getScope() {
        return scope;
    }

    public AccessTokenResponse setScope(String[] scope) {
        this.scope = scope;
        return this;
    }
}
