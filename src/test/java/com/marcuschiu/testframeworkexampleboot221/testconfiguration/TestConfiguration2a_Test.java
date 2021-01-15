package com.marcuschiu.testframeworkexampleboot221.testconfiguration;

import com.marcuschiu.testframeworkexampleboot221.testconfiguration.config.DefaultAConfiguration;
import com.marcuschiu.testframeworkexampleboot221.testconfiguration.config.DefaultComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @SpringBootTest - by default does not bootstrap classes annotated with @TestConfiguration
 * there are 2 ways to include them into the tests:
 * - using @Import() - see TestConfiguration2a_Test.java
 * - using static class - see TestConfiguration2b_Test.java
 */
@SpringBootTest
@Import(DefaultAConfiguration.class)
public class TestConfiguration2a_Test {

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
}
