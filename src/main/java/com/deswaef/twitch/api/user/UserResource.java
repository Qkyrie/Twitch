package com.deswaef.twitch.api.user;

import com.deswaef.twitch.api.user.domain.User;
import com.deswaef.twitch.exception.UnAuthorizedException;
import retrofit.RestAdapter;

import java.util.Optional;

/**
 * User: Quinten
 * Date: 16-9-2014
 * Time: 22:19
 *
 * @author Quinten De Swaef
 */
public class UserResource {

    private UserService userService;

    public Optional<User> user(String user) {
        try {
            return Optional.ofNullable(userService.user(user));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public Optional<User> getAuthenticatedUser(String accessToken) throws UnAuthorizedException{
        try {
            return Optional.ofNullable(userService.authenticatedUser(accessToken));
        } catch (Exception ex) {
            throw new UnAuthorizedException();
        }
    }


    public UserResource url(RestAdapter restAdapter) {
        this.userService = restAdapter.create(UserService.class);
        return this;
    }
}
