package com.deswaef.twitch.api.ingests;

import com.deswaef.twitch.api.APIResource;
import com.deswaef.twitch.api.ingests.domain.Ingest;
import com.deswaef.twitch.api.ingests.domain.IngestResult;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Quinten
 * Date: 28-9-2014
 * Time: 23:46
 *
 * @author Quinten De Swaef
 */
public class IngestsResource extends APIResource {
    private String baseUrl;

    public List<Ingest> ingests() {
        try {
            return rest().getForObject(String.format("%s/ingests", baseUrl), IngestResult.class).getIngests();
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    public IngestsResource url(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }
}
