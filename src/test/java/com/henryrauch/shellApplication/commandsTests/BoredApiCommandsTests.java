package com.henryrauch.shellApplication.commandsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.henryrauch.shellApplication.clients.BoredApiClient;
import com.henryrauch.shellApplication.commands.BoredApiCommands;
import com.henryrauch.shellApplication.model.ActivityResponse;
import com.henryrauch.shellApplication.services.ShellCommandsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



public class BoredApiCommandsTests {


    @Mock
    private BoredApiClient boredApiClient;

    @Mock
    private ShellCommandsService shellCommandsService;

    @InjectMocks
    private BoredApiCommands boredApiCommands;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRandomActivity() {
        ActivityResponse mockResponse = new ActivityResponse("random activity", 0.1F, "random type", 1, 0.4F,"random accesibility","1", true,"randomlink.com","0000001");
        when(boredApiClient.getRandomActivity()).thenReturn(mockResponse);
        when(shellCommandsService.adaptResponse(mockResponse)).thenReturn("Adapted random activity");

        String result = boredApiCommands.getRandomActivity();

        assertEquals("Adapted random activity", result);
    }

    @Test
    void testGetFilterActivityByType() {
        ActivityResponse[] mockResponses = new ActivityResponse[] {
                new ActivityResponse("random activity", 0.1F, "random type", 1, 0.4F,"random accesibility","1", true,"randomlink.com","0000001"), new ActivityResponse("random activity", 0.1F, "random type", 1, 0.4F,"random accesibility","1", true,"randomlink.com","0000001")
        };
        when(boredApiClient.getFilterActivityByType("education")).thenReturn(mockResponses);
        when(shellCommandsService.convertArrayToString(mockResponses)).thenReturn("activity1, activity2");

        String result = boredApiCommands.getFilterActivityByType("education");

        assertEquals("activity1, activity2", result);
    }

    @Test
    void testGetFilterActivityByParticipants() {
        ActivityResponse[] mockResponses = new ActivityResponse[] {
                new ActivityResponse("random activity", 0.1F, "random type", 1, 0.4F,"random accesibility","1", true,"randomlink.com","0000001"), new ActivityResponse("random activity", 0.1F, "random type", 2, 0.4F,"random accesibility","1", true,"randomlink.com","0000001")
        };
        when(boredApiClient.getFilterActivityByParticipants("1")).thenReturn(mockResponses);
        when(shellCommandsService.convertArrayToString(mockResponses)).thenReturn("activity1");

        String result = boredApiCommands.getFilterActivityByParticipants("1");

        assertEquals("activity1", result);
    }


}
