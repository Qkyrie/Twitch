package com.deswaef.twitch.api.oauth;


import com.deswaef.twitch.api.user.AuthenticatedUserResource;
import com.deswaef.twitch.exception.UnAuthorizedException;
import org.junit.Before;
import org.junit.Test;

import static com.deswaef.twitch.util.ThrowableAssertion.assertThrown;

public class AuthorizingUserConnectorTest {

    private AuthenticatedUserResource connector;

    @Before
    public void init() {
        connector = new AuthenticatedUserResource().url("https://api.twitch.tv/kraken");
    }

    @Test
    public void testAndFaultyAccessToken() {
        assertThrown(
                () -> connector.getAuthenticatedUser("token")
        ).isInstanceOf(UnAuthorizedException.class);
    }
}