package com.deswaef.twitch.work;


import com.deswaef.twitch.exception.UnAuthorizedException;
import org.junit.Before;
import org.junit.Test;

import static com.deswaef.twitch.util.TwitchTestHelper.assertThrows;

public class AuthorizingUserConnectorTest {

    private AuthorizingUserConnector connector;

    @Before
    public void init() {
        connector = new AuthorizingUserConnector().url("https://api.twitch.tv/kraken");
    }

    @Test
    public void testAndFaultyAccessToken() {
        assertThrows(UnAuthorizedException.class, () -> connector.getAuthenticatedUser("token"));
    }
}