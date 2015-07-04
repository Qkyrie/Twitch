package com.deswaef.twitch.util;

import org.junit.Test;

import static com.deswaef.twitch.util.AuthorizationURLBuilder.buildAuthorizationUrl;
import static com.deswaef.twitch.util.ThrowableAssertion.assertThrown;
import static org.fest.assertions.Assertions.assertThat;

public class AuthorizationURLBuilderTest {

    public static final String SCOPE_1 = "scope1";
    public static final String SCOPE_2 = "scope2";
    public static final String REDIRECT_URI = "redirectURI";
    public static final String CLIENT_ID = "clientId";
    public static final String BASE_URL = "baseUrl";

    @Test
    public void baseUrlShouldBeSet() {

        assertThrown(
                () -> buildAuthorizationUrl()
                        .clientId(CLIENT_ID)
                        .redirectURI(REDIRECT_URI)
                        .withScope(SCOPE_1)
                        .withScope(SCOPE_2)
                        .toString()
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void clientIdShouldBeSet() {
        assertThrown(
                () -> buildAuthorizationUrl()
                        .baseUrl(BASE_URL)
                        .redirectURI(REDIRECT_URI)
                        .withScope(SCOPE_1)
                        .withScope(SCOPE_2)
                        .toString()
        ).isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void redirectURIShouldBeSet() {
        assertThrown(
                () -> buildAuthorizationUrl()
                        .baseUrl(BASE_URL)
                        .clientId(CLIENT_ID)
                        .withScope(SCOPE_1)
                        .withScope(SCOPE_2)
                        .toString()
        ).isInstanceOf(IllegalStateException.class);
    }


    @Test
    public void scopeShouldBeSet() {
        assertThrown(
                () -> buildAuthorizationUrl()
                        .baseUrl(BASE_URL)
                        .clientId(CLIENT_ID)
                        .redirectURI(REDIRECT_URI)
                        .toString()
        ).isInstanceOf(IllegalStateException.class)
                .hasMessage("Cannot build authentication url, please set the scopes first");
    }

    @Test
    public void generatesCorrectURIWith1Scope() {
        assertThat(
                buildAuthorizationUrl()
                        .baseUrl(BASE_URL)
                        .clientId(CLIENT_ID)
                        .redirectURI(REDIRECT_URI)
                        .withScope(SCOPE_1)
                        .toString()
        ).isEqualTo(String.format("%s/oauth2/authorize?response_type=code&client_id=%s&redirect_uri=%s&scope=%s", BASE_URL, CLIENT_ID, REDIRECT_URI, SCOPE_1));
    }

    @Test
    public void generatesCorrectURIWithMoreScopes(){
        assertThat(
                buildAuthorizationUrl()
                        .baseUrl(BASE_URL)
                        .clientId(CLIENT_ID)
                        .redirectURI(REDIRECT_URI)
                        .withScope(SCOPE_1)
                        .withScope(SCOPE_2)
                        .toString()
        ).isEqualTo(String.format("%s/oauth2/authorize?response_type=code&client_id=%s&redirect_uri=%s&scope=%s+%s", BASE_URL, CLIENT_ID, REDIRECT_URI, SCOPE_1, SCOPE_2));
    }
}