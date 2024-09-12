package com.henryrauch.shellApplication.clients;

import com.henryrauch.shellApplication.model.ActivityResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

/**
 * Client interface for interacting with the Bored API.
 * Provides methods to fetch random activities and filter activities by type or number of participants.
 */
public interface BoredApiClient {

    //Fetches activities filtered by type from the Bored API.
    @GetExchange("/random")
    ActivityResponse getRandomActivity();

    //Fetches activities filtered by type from the Bored API.
    @GetExchange("/filter")
    ActivityResponse[] getFilterActivityByType(@RequestParam("type") String type);

    //Fetches activities filtered by the number of participants from the Bored API.
    @GetExchange("/filter")
    ActivityResponse[] getFilterActivityByParticipants(@RequestParam("participants") String participants);

}
