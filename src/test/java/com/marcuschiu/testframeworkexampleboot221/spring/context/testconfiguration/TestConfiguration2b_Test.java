package com.marcuschiu.testframeworkexampleboot221.spring.context.testconfiguration;

import com.marcuschiu.testframeworkexampleboot221.spring.context.testconfiguration.config.DefaultComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @SpringBootTest - by default does not bootstrap classes annotated with @TestConfiguration
 * there are 2 ways to include them into the tests:
 * - using @Import() - see TestConfiguration2a_Test.java
 * - using static class - see TestConfiguration2b_Test.java
 */
@SpringBootTest
public class TestConfiguration2b_Test {

    @Autowired
    DefaultComponent defaultComponentA; // name is bound

    @Autowired
    DefaultComponent defaultComponentB; // name is bound

    @Test
    public void test() {
        assertEquals("created from @TestConfiguration", defaultComponentA.state);
        assertEquals("created from @Configuration", defaultComponentB.state);
        assertNotEquals(defaultComponentA, defaultComponentB);
    }

    /**
     * this is copied from config/DefaultAConfiguration.java
     */
    @TestConfiguration // @Configuration works too, but note fails test
    static class DefaultAConfiguration {

        @Bean
        public DefaultComponent defaultComponentA() {
            return new DefaultComponent("created from @TestConfiguration");
        }
    }
}
