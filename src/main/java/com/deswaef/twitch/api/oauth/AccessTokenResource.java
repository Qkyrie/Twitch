package com.deswaef.twitch.api.oauth;


import com.deswaef.twitch.api.oauth.domain.AccessTokenRequest;
import com.deswaef.twitch.api.oauth.domain.AccessTokenResponse;
import retrofit.RestAdapter;

/**
 * User: Quinten
 * Date: 16-9-2014
 * Time: 14:24
 *
 * @author Quinten De Swaef
 */
public class AccessTokenResource {

    private AccessTokenService accessTokenService;

    private AccessTokenRequest requestTemplate;

    public AccessTokenResource() {
        super();
        requestTemplate = new AccessTokenRequest();
    }

    public AccessTokenResponse requestToken(String accessCode) {
        try {
            return accessTokenService.requestToken(requestTemplate.copy(accessCode));
        } catch(Exception ex) {
            return AccessTokenResponse.unknown_issue();
        }
    }

    public AccessTokenResource setClientId(String clientId) {
        this.requestTemplate.setClient_id(clientId);
        return this;
    }


    public AccessTokenResource setClientSecret(String clientSecret) {
        this.requestTemplate.setClient_secret(clientSecret);
        return this;
    }

    public AccessTokenResource setRedirectUrl(String redirectUrl) {
        this.requestTemplate.setRedirect_uri(redirectUrl);
        return this;
    }

    public AccessTokenResource setBaseUrl(RestAdapter restAdaptor) {
        this.accessTokenService = restAdaptor.create(AccessTokenService.class);
        return this;
    }
}
