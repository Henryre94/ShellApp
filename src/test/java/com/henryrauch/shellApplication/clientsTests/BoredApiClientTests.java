package com.henryrauch.shellApplication.clientsTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.henryrauch.shellApplication.clients.BoredApiClient;
import com.henryrauch.shellApplication.model.ActivityResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class BoredApiClientTests {
    @Autowired
    private BoredApiClient boredApiClient;

    @Test
    void testGetRandomActivity() {
        // Act: Call the actual method
        ActivityResponse result = boredApiClient.getRandomActivity();

        // Assert: Verify the results meet expectations
        assertNotNull(result);
    }



}
