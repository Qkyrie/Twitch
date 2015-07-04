package com.deswaef.twitch.util;


import static com.deswaef.twitch.exception.States.state;

/**
 * User: Quinten
 * Date: 19-9-2014
 * Time: 11:47
 *
 * @author Quinten De Swaef
 */
public class AuthorizationURLBuilder {

    private static final String authorizationURL = "/oauth2/authorize";

    private String baseUrl;
    private String clientId;
    private String redirectURI;
    private String scopes;

    public static AuthorizationURLBuilder buildAuthorizationUrl() {
        return new AuthorizationURLBuilder();
    }

    public AuthorizationURLBuilder baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public AuthorizationURLBuilder clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public AuthorizationURLBuilder redirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
        return this;
    }

    public AuthorizationURLBuilder withScope(String scope) {
        if(this.scopes == null || scope.isEmpty()) {
            this.scopes = scope;
        } else {
            this.scopes += String.format("+%s", scope);
        }
        return this;
    }


    @Override
    public String toString() {
        state(notBlank(baseUrl), "Cannot build authentication url, please set the baseURL first");
        state(notBlank(clientId), "Cannot build authentication url, please set the clientId first");
        state(notBlank(redirectURI), "Cannot build authentication url, please set the redirectURI first");
        state(notBlank(scopes), "Cannot build authentication url, please set the scopes first");

        return String.format("%s%s?response_type=code&client_id=%s&redirect_uri=%s&scope=%s", baseUrl, authorizationURL, clientId, redirectURI, scopes);
    }

    private boolean notBlank(String baseUrl) {
        return baseUrl != null && !baseUrl.isEmpty();
    }
}
