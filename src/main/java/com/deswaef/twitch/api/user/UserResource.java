package com.deswaef.twitch.api.user;

import com.deswaef.twitch.api.APIResource;
import com.deswaef.twitch.api.user.domain.User;
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
public class UserResource extends APIResource {
    private String baseUrl;

    public UserResource() {
        super();
    }

    public UserResource(RestTemplateProvider rtProvider) {
        super(rtProvider);
    }

    public Optional<User> user(String user) {
        try {
            return Optional.ofNullable(rest().getForObject(String.format("%s/users/%s", baseUrl, user), User.class));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public Optional<User> getAuthenticatedUser(String accessToken) throws UnAuthorizedException{
        try {
            return Optional.ofNullable(rest().getForObject(getUrlForAuthenticatedUser(accessToken), User.class));
        } catch (HttpClientErrorException ex) {
            throw new UnAuthorizedException();
        }
    }

    private String getUrlForAuthenticatedUser(String accessToken) {
        return baseUrl + "/user?oauth_token="+accessToken;
    }

    public UserResource url(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }
}
