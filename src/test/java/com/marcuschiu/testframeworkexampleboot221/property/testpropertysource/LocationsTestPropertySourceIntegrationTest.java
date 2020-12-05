package com.marcuschiu.testframeworkexampleboot221.property.testpropertysource;

import com.marcuschiu.testframeworkexampleboot221.config.PropertyUsingComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.Assert.assertEquals;

/**
 * @ContextConfiguration - loads and configures the ApplicationContext for the scenario
 * @TestPropertySource - class-level annotation to define a new configuration source
 * and overrides any properties in PropertyUsingComponent.class
 */
@SpringBootTest
@TestPropertySource(locations = "/application-test.properties") //
public class LocationsTestPropertySourceIntegrationTest {

    @Autowired
    PropertyUsingComponent propertyUsingComponent;

    @Test
    public void test() {
        // stringOne property overridden by src/test/resources/application-test.properties
        assertEquals(
                "@TestPropertySource(locations={'/application-test.properties'})",
                propertyUsingComponent.getStringOne());
        // stringTwo property is NOT overridden
        assertEquals("string two", propertyUsingComponent.getStringTwo());
    }
}
