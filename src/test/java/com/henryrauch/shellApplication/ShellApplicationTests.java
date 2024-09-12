package com.henryrauch.shellApplication;

import com.henryrauch.shellApplication.clients.BoredApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class ShellApplicationTests {

    @Test
    void testBoredApiClientCreation() {
        // Arrange
        ShellApplication app = new ShellApplication();

        // Act
        BoredApiClient boredApiClient = app.boredApiClient();

        // Assert
        assertNotNull(boredApiClient, "BoredApiClient should not be null");
    }
}
