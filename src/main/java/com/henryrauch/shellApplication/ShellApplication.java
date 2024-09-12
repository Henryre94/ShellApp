package com.henryrauch.shellApplication;

import com.henryrauch.shellApplication.clients.BoredApiClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.shell.command.CommandRegistration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * Main application class for launching the Spring Boot application.
 * Configures the application context and beans.
 */
@SpringBootApplication
public class ShellApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShellApplication.class, args);
	}

	/**
	 * Creates a bean for the BoredApiClient interface.
	 * Configures the WebClient and HttpServiceProxyFactory for making API calls.
	 *
	 * @return a BoredApiClient instance for interacting with the Bored API
	 */
	@Bean
	BoredApiClient boredApiClient() {
		WebClient client = WebClient.builder()
				.baseUrl("https://bored-api.appbrewery.com")
				.build();

		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();
		return factory.createClient(BoredApiClient.class);
	}

}
