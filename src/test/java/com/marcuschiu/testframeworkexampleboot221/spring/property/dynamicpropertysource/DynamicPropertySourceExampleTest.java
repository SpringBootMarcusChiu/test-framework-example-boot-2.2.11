package com.marcuschiu.testframeworkexampleboot221.spring.property.dynamicpropertysource;

import com.marcuschiu.testframeworkexampleboot221.config.PropertyUsingComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DynamicPropertySourceExampleTest {

    static String property = "new";

    @Autowired
    private PropertyUsingComponent propertyUsingComponent;

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
        registry.add("string.one", () -> property);
    }

    @Test
    void test() {
        assertEquals("new", propertyUsingComponent.getStringOne());
    }
}
