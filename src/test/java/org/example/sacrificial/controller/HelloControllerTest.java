package org.example.sacrificial.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldReturnHelloMessage() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }

    @Test
    void shouldReturnPersonalizedGreeting() {
        ResponseEntity<String> response = restTemplate.getForEntity("/greet?name=Gemini", String.class);
        assertThat(response.getBody()).isEqualTo("Hello, Gemini!");
    }

    @Test
    void shouldEchoMessage() {
        String message = "This is a test message";
        ResponseEntity<String> response = restTemplate.postForEntity("/echo", message, String.class);
        assertThat(response.getBody()).isEqualTo("Echo: " + message);
    }
}
