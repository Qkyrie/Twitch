package com.deswaef.twitch.api.ingests.domain;


import java.util.List;

/**
 * User: Quinten
 * Date: 28-9-2014
 * Time: 23:47
 *
 * @author Quinten De Swaef
 */
public class IngestResult {
    private List<Ingest> ingests;

    public List<Ingest> getIngests() {
        return ingests;
    }

    public void setIngests(List<Ingest> ingests) {
        this.ingests = ingests;
    }
}
