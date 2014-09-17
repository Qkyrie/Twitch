package com.deswaef.twitch.work;

import com.deswaef.twitch.domain.AuthenticatedUser;
import com.deswaef.twitch.exception.UnAuthorizedException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * User: Quinten
 * Date: 16-9-2014
 * Time: 22:19
 *
 * @author Quinten De Swaef
 */
public class AuthorizingUserConnector {
    private String baseUrl;

    RestTemplate template;

    public Optional<AuthenticatedUser> getAuthenticatedUser(String accessToken) throws UnAuthorizedException{
        try {
            template = new RestTemplate();
            return Optional.ofNullable(template.getForObject(getUrlForAuthenticatedUser(accessToken), AuthenticatedUser.class));
        } catch (HttpClientErrorException ex) {
            throw new UnAuthorizedException();
        }
    }

    private String getUrlForAuthenticatedUser(String accessToken) {
        return baseUrl + "/user" + "?oauth_token="+accessToken;
    }

    public AuthorizingUserConnector url(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }
}
