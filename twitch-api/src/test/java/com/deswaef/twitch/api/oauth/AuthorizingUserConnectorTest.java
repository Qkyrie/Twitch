package com.deswaef.twitch.api.oauth;


import com.deswaef.twitch.api.user.UserResource;
import com.deswaef.twitch.exception.UnAuthorizedException;
import org.junit.Before;
import org.junit.Test;

import static com.deswaef.twitch.util.ThrowableAssertion.assertThrown;

public class AuthorizingUserConnectorTest {

    private UserResource connector;

    @Before
    public void init() {
        connector = new UserResource().url("https://api.twitch.tv/kraken");
    }

    @Test
    public void testAndFaultyAccessToken() {
        assertThrown(
                () -> connector.getAuthenticatedUser("token")
        ).isInstanceOf(UnAuthorizedException.class);
    }
}