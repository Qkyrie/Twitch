package com.deswaef.twitch.api.ingests;

import com.deswaef.twitch.api.ingests.domain.Ingest;
import com.deswaef.twitch.api.ingests.domain.IngestResult;
import retrofit.RestAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Quinten
 * Date: 28-9-2014
 * Time: 23:46
 *
 * @author Quinten De Swaef
 */
public class IngestsResource {

    private IngestsService ingestsService;

    public List<Ingest> ingests() {
        try {
            IngestResult ingests = ingestsService.ingests();
            if (ingests !=  null) {
                return ingests.getIngests();
            } else {
                return new ArrayList<>();
            }
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    public IngestsResource url(RestAdapter restAdapter) {
        this.ingestsService = restAdapter.create(IngestsService.class);
        return this;
    }
}
