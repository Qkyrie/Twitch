package com.deswaef.twitch.api;


import com.deswaef.twitch.api.user.AuthenticatedUserResource;
import com.deswaef.twitch.exception.UnAuthorizedException;
import org.junit.Before;
import org.junit.Test;

import static com.deswaef.twitch.util.TwitchTestHelper.assertThrows;

public class AuthorizingUserConnectorTest {

    private AuthenticatedUserResource connector;

    @Before
    public void init() {
        connector = new AuthenticatedUserResource().url("https://api.twitch.tv/kraken");
    }

    @Test
    public void testAndFaultyAccessToken() {
        assertThrows(UnAuthorizedException.class, () -> connector.getAuthenticatedUser("token"));
    }
}