package com.deswaef.twitch.api.user;

import com.deswaef.twitch.api.user.domain.User;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * User: Quinten
 * Date: 5-7-2015
 * Time: 00:44
 *
 * @author Quinten De Swaef
 */
public interface UserService {
    @GET("/users/{user}")
    User user(@Path("user") String user);

    @GET("/user")
    User authenticatedUser(@Query("oauth_token") String accessToken);
}
