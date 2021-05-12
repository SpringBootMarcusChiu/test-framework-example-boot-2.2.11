package com.marcuschiu.testframeworkexampleboot221.spring.property.dynamicpropertysource;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

public class ExampleTest {

    /**
     * This is the actual part where you make SDN+OGM aware of the different config and the
     * point it to the test harness embedded bolt connector.
     * user name and password are null in that case.
     * This way of configuring tests works since Spring Boot 2.2.6
     *
     * @param registry The target of dynamic configuration
     */
    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.neo4j.uri", () -> "neo4j://localhost");
        registry.add("spring.data.neo4j.username", () -> "neo4j");
        registry.add("spring.data.neo4j.password", () -> "password");
    }
}
