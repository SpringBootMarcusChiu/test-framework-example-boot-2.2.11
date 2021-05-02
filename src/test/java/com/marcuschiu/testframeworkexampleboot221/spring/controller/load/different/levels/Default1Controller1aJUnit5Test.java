package com.marcuschiu.testframeworkexampleboot221.spring.controller.load.different.levels;

import com.marcuschiu.testframeworkexampleboot221.spring.controller.Default1Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Testing Controller By Starting Entire Server
 * WebEnvironment=RANDOM_PORT to start an EMBEDDED http server with a random port (useful to avoid conflicts in test environments)
 * WebEnvironment=DEFINED_PORT to start an EMBEDDED http server with application.properties port
 * WebEnvironment=MOCK to start a MOCK http server
 * WebEnvironment=NONE no http server
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class Default1Controller1aJUnit5Test {

    // injection of the random port
    @LocalServerPort
    int port;

    // Spring Boot automatically provided
    // https://www.baeldung.com/spring-boot-testresttemplate
    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    Default1Controller controller;

    @Test
    public void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws InterruptedException {
        System.out.println("port number: " + port);
        System.out.println(controller.i);
        controller.i++;
        String actual = restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertEquals("Hello, World", actual);
    }

    @Test
    public void greetingShouldReturnDefaultMessage_entity() {
        System.out.println(controller.i);
        controller.i++;
        ResponseEntity<String> actual = restTemplate.getForEntity("http://localhost:" + port + "/", String.class);
        assertEquals("Hello, World", actual.getBody());
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
}
