package com.henryrauch.shellApplication.servicesTests;

import com.henryrauch.shellApplication.model.ActivityResponse;
import com.henryrauch.shellApplication.services.ShellCommandsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Service;


import static org.junit.jupiter.api.Assertions.assertEquals;


@Service
public class ShellCommandsServiceTests {

    @InjectMocks
    private ShellCommandsService shellCommandsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConvertArrayToString() {

        ActivityResponse[] responses = {
                new ActivityResponse("Go for a Walk", 0.1F, "recreational", 1, 0.4F,"random accesibility","1", true,"randomlink.com","0000001"),
                new ActivityResponse("Play Soccer", 0.1F, "recreational", 22, 0.4F,"random accesibility","1", true,"randomlink.com","0000001")
        };

        String expected = "Activity: Go for a Walk, Participants: 1, Type: recreational\n" +
                "Activity: Play Soccer, Participants: 22, Type: recreational\n";


        String result = shellCommandsService.convertArrayToString(responses);

        assertEquals(expected, result);
    }


    @Test
    void testAdaptResponse() {

        ActivityResponse response = new ActivityResponse("Go for a Walk", 0.1F, "recreational", 1, 0.4F,"random accesibility","1", true,"randomlink.com","0000001");

        String expected = "Activity: Go for a Walk, Participants: 1,  Type: recreational";

        String result = shellCommandsService.adaptResponse(response);

        assertEquals(expected, result);
    }


}
