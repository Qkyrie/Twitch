package com.deswaef.twitch.api.user;

import com.deswaef.twitch.api.user.domain.AuthenticatedUser;
import com.deswaef.twitch.rest.RestTemplateProvider;
import net.vidageek.mirror.dsl.Mirror;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticatedUserResourceTest {

    public static final String TOKEN = "this_is_token";
    public static final String BASE_URL = "base_url";
    private AuthenticatedUserResource userResource;

    @Mock
    private RestTemplateProvider restTemplateProvider;
    @Mock
    private RestTemplate restTemplate;

    @Test
    public void initializedAndUrlIsSet() {
        userResource = new AuthenticatedUserResource().url(BASE_URL);
        assertThat(new Mirror().on(userResource).get().field("baseUrl")).isEqualTo(BASE_URL);
    }

    @Before
    public void init() {
        when(restTemplateProvider.rest()).thenReturn(restTemplate);
        userResource = new AuthenticatedUserResource(restTemplateProvider).url(BASE_URL);

    }

    @Test
    public void callsCorrectURI() {
        userResource.getAuthenticatedUser(TOKEN);
        verify(restTemplate).getForObject(String.format("%s/user?oauth_token=%s", BASE_URL, TOKEN), AuthenticatedUser.class);
    }

}