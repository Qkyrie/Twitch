package com.deswaef.twitch.api.ingests;

import com.deswaef.twitch.api.ingests.domain.Ingest;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class IngestsResourceTest {

    private IngestsResource ingestsResource;

    @Before
    public void init() {
        ingestsResource = new IngestsResource().url("https://api.twitch.tv/kraken");
    }

    @Test
    public void ingestsReturnsAllIngests() {
        assertThat(ingestsResource.ingests()).isNotEmpty();
    }

    @Test
    public void ingestsHaveValidFields() {
        ingestsResource
                .ingests()
                .stream()
                .forEach(this::validateIngest);
    }

    private void validateIngest(Ingest ingest) {
        assertThat(ingest.getId()).isGreaterThan(0);
        assertThat(ingest.getAvailability()).isNotNull();
        assertThat(ingest.getByDefault()).isNotNull();
        assertThat(ingest.getUrlTemplate()).isNotEmpty();
        assertThat(ingest.getName()).isNotEmpty();
    }

}