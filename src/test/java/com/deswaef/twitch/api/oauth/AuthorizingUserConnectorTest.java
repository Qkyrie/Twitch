package com.deswaef.twitch.api.oauth;


import com.deswaef.twitch.api.user.UserResource;
import com.deswaef.twitch.exception.UnAuthorizedException;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import static com.deswaef.twitch.util.ThrowableAssertion.assertThrown;

public class AuthorizingUserConnectorTest {

    private UserResource connector;

    private RestAdapter restAdapter;

    @Before
    public void init() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.twitch.tv/kraken")
                .build();
        connector = new UserResource().url(restAdapter);
    }

    @Test
    public void testAndFaultyAccessToken() {
        assertThrown(
                () -> connector.getAuthenticatedUser("token")
        ).isInstanceOf(UnAuthorizedException.class);
    }
}