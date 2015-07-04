package com.deswaef.twitch.api.ingests;

import com.deswaef.twitch.api.ingests.domain.IngestResult;
import retrofit.http.GET;

/**
 * User: Quinten
 * Date: 5-7-2015
 * Time: 00:37
 *
 * @author Quinten De Swaef
 */
public interface IngestsService {

    @GET("/ingests")
    IngestResult ingests();

}
