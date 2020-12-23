package com.marcuschiu.testframeworkexampleboot221.controller.load.different.levels;

import com.marcuschiu.testframeworkexampleboot221.controller.Default1Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Testing Controller By Starting Entire Server
 * WebEnvironment=RANDOM_PORT to start the server with a random port (useful to avoid conflicts in test environments)
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Default1Controller1JUnit5Test {

    // injection of the random port
    @LocalServerPort
    int port;

    // Spring Boot automatically provided
    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    Default1Controller controller;

    @Test
    public void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        System.out.println(controller.i);
        controller.i++;
        String actual = restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertEquals("Hello, World", actual);
    }
}
