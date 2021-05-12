package com.marcuschiu.testframeworkexampleboot221.other.testcontainer;

import org.junit.ClassRule;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.GenericContainer;

import static org.junit.Assert.assertEquals;

public class GenericContainerJUnit4Test {

    @ClassRule
    public static GenericContainer simpleWebServer
            = new GenericContainer("alpine:3.2")
            .withExposedPorts(80)
            .withCommand("/bin/sh", "-c", "while true; do echo \"HTTP/1.1 200 OK\n\nHello World!\" | nc -l -p 80; done");

    @Test
    public void givenSimpleWebServerContainer_whenGetRequest_thenReturnsResponse() {
        String address = "http://" + simpleWebServer.getContainerIpAddress() + ":" + simpleWebServer.getMappedPort(80);
        String response = new RestTemplate().getForEntity(address, String.class).getBody();

        assertEquals("Hello World!\n", response);
    }
}
