package com.deswaef.twitch.api.user;

import com.deswaef.twitch.api.user.domain.User;
import net.vidageek.mirror.dsl.Mirror;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import retrofit.RestAdapter;

import java.util.Optional;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserResourceTest {

    public static final String TOKEN = "this_is_token";
    public static final String BASE_URL = "https://api.twitch.tv/kraken";
    public RestAdapter restAdapter;

    private UserResource userResource;

    @Before
    public void init() {
        restAdapter = new RestAdapter.Builder().setEndpoint(BASE_URL).build();
        userResource = new UserResource().url(restAdapter);
    }

    @Test
    public void initializedAndUrlIsSet() {
        userResource = new UserResource().url(restAdapter);
        assertThat(new Mirror().on(userResource).get().field("userService")).isNotNull();
    }


    @Test
    public void getPublicUser() {
        Optional<User> streamingforanimals = userResource.user("streamingforanimals");
        assertThat(streamingforanimals.isPresent()).isTrue();
    }

    @Test
    public void publicUserAndFieldsAreValid(){
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
        assertThat(userResource.user("non_existing_user_xxxx").isPresent()).isFalse();
    }

}