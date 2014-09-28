package com.deswaef.twitch.api.user;

import com.deswaef.twitch.api.user.domain.User;
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
public class UserResourceTest {

    public static final String TOKEN = "this_is_token";
    public static final String BASE_URL = "base_url";
    private UserResource userResource;

    @Mock
    private RestTemplateProvider restTemplateProvider;
    @Mock
    private RestTemplate restTemplate;

    @Test
    public void initializedAndUrlIsSet() {
        userResource = new UserResource().url(BASE_URL);
        assertThat(new Mirror().on(userResource).get().field("baseUrl")).isEqualTo(BASE_URL);
    }

    @Before
    public void init() {
        when(restTemplateProvider.rest()).thenReturn(restTemplate);
        userResource = new UserResource(restTemplateProvider).url(BASE_URL);
    }

    @Test
    public void callsCorrectURI() {
        userResource.getAuthenticatedUser(TOKEN);
        verify(restTemplate).getForObject(String.format("%s/user?oauth_token=%s", BASE_URL, TOKEN), User.class);
    }

    @Test
    public void getPublicUser() {
        userResource = new UserResource().url("https://api.twitch.tv/kraken");
        Optional<User> streamingforanimals = userResource.user("streamingforanimals");
        assertThat(streamingforanimals.isPresent()).isTrue();
    }

    @Test
    public void publicUserAndFieldsAreValid(){
        userResource = new UserResource().url("https://api.twitch.tv/kraken");
        userResource.user("streamingforanimals").ifPresent(
                this::validateUser
        );
    }

    private void validateUser(User user) {
        assertThat(user.getId()).isGreaterThan(0);
        assertThat(user.getName()).isNotEmpty();
        assertThat(user.getUpdatedAt()).isNotNull();
        assertThat(user.getCreatedAt()).isNotNull();
        assertThat(user.getDisplayName()).isNotNull();
    }

    @Test
    public void getPublicUnexistingUser(){
        userResource = new UserResource().url("https://api.twitch.tv/kraken");
        assertThat(userResource.user("non_existing_user_xxxx").isPresent()).isFalse();
    }

}