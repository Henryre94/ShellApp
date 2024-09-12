package com.henryrauch.shellApplication.commands;

import com.henryrauch.shellApplication.clients.BoredApiClient;
import com.henryrauch.shellApplication.model.ActivityResponse;
import com.henryrauch.shellApplication.services.ShellCommandsService;
import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;
import org.springframework.shell.completion.CompletionResolver;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.standard.ValueProvider;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Shell component for interacting with the Bored API.
 * Provides commands to fetch and filter activities based on various criteria.
 */
@ShellComponent
public class BoredApiCommands {

    private final BoredApiClient boredApiClient;
    private final ShellCommandsService shellCommandsService;


    /**
     * Constructor for initializing the BoredApiCommands component.
     *
     * @param boredApiClient       the client used to interact with the Bored API
     * @param shellCommandsService service for adapting and converting API responses
     */
    public BoredApiCommands(BoredApiClient boredApiClient, ShellCommandsService shellCommandsService) {
        this.boredApiClient = boredApiClient;
        this.shellCommandsService = shellCommandsService;
    }

    /**
     * Command to return a random activity.
     *
     * @return a string representation of a random activity
     */
    @ShellMethod(key = "random", value = "Return a random activity")
    public String getRandomActivity() {
        ActivityResponse randomActivity = boredApiClient.getRandomActivity();
        return shellCommandsService.adaptResponse(randomActivity);
    }


    /**
     * Command to return a list of activities filtered by type.
     *
     * @param type the type of activity to filter by (default is "education")
     * @return a string representation of the filtered activities
     */
    @ShellMethod(key = "type", value = "Return a list of all the activities filtered by type")
    public String getFilterActivityByType(
            @ShellOption(defaultValue = "education") String type) {
        ActivityResponse[] filterActivities = boredApiClient.getFilterActivityByType(type);
        return shellCommandsService.convertArrayToString(filterActivities);
    }

    /**
     * Command to return a list of activities filtered by the number of participants.
     *
     * @param participants the number of participants to filter by (default is "1")
     * @return a string representation of the filtered activities
     */
    @ShellMethod(key = "participants", value = "Return a list of all the activities filtered by participants")
    public String getFilterActivityByParticipants(
            @ShellOption(defaultValue = "1") String participants) {
        ActivityResponse[] filterActivities = boredApiClient.getFilterActivityByParticipants(participants);
        return shellCommandsService.convertArrayToString(filterActivities);
    }

}



