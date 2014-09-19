package com.deswaef.twitch.api.user;

import com.deswaef.twitch.api.APIResource;
import com.deswaef.twitch.api.user.domain.AuthenticatedUser;
import com.deswaef.twitch.exception.UnAuthorizedException;
import com.deswaef.twitch.rest.RestTemplateProvider;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

/**
 * User: Quinten
 * Date: 16-9-2014
 * Time: 22:19
 *
 * @author Quinten De Swaef
 */
public class AuthenticatedUserResource extends APIResource {
    private String baseUrl;

    public AuthenticatedUserResource() {
        super();
    }

    public AuthenticatedUserResource(RestTemplateProvider rtProvider) {
        super(rtProvider);
    }

    public Optional<AuthenticatedUser> getAuthenticatedUser(String accessToken) throws UnAuthorizedException{
        try {
            return Optional.ofNullable(rest().getForObject(getUrlForAuthenticatedUser(accessToken), AuthenticatedUser.class));
        } catch (HttpClientErrorException ex) {
            throw new UnAuthorizedException();
        }
    }

    private String getUrlForAuthenticatedUser(String accessToken) {
        return baseUrl + "/user?oauth_token="+accessToken;
    }

    public AuthenticatedUserResource url(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }
}
