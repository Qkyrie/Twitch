package com.deswaef.twitch.example;

import com.deswaef.twitch.configuration.Twitch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Test to ensure the entire setup still works and nothing is broken
 *
 * @author Quinten De Swaef
 */
@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTest("server.port:0")
@SpringApplicationConfiguration(classes = TwitchExample.class)
public class TwitchExampleTest {

    @Autowired
    private Twitch twitch;

    @Test
    public void setupEnvironment() {
        assertThat(twitch).isNotNull();
    }
}
