package com.deswaef.twitch.api.oauth;

import com.deswaef.twitch.api.oauth.domain.AccessTokenRequest;
import com.deswaef.twitch.api.oauth.domain.AccessTokenResponse;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * User: Quinten
 * Date: 5-7-2015
 * Time: 00:40
 *
 * @author Quinten De Swaef
 */
public interface AccessTokenService {

    @POST("/oauth2/token")
    AccessTokenResponse requestToken(@Body AccessTokenRequest accessTokenRequest);

}
