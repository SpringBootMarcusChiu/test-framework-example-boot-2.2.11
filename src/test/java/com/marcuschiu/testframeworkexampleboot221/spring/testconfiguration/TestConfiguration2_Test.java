package com.marcuschiu.testframeworkexampleboot221.spring.testconfiguration;

import com.marcuschiu.testframeworkexampleboot221.spring.testconfiguration.config.DefaultComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @SpringBootTest - by default does not bootstrap classes annotated with @TestConfiguration
 * there are 2 ways to include them into the tests:
 * - see
 */
@SpringBootTest
public class TestConfiguration2_Test {

    @Autowired
    DefaultComponent defaultComponentA_not_bound_by_name;

    @Autowired
    DefaultComponent defaultComponentB_not_bound_by_name;

    @Test
    public void test() {
        assertEquals("created from @Configuration", defaultComponentA_not_bound_by_name.state);
        assertEquals("created from @Configuration", defaultComponentB_not_bound_by_name.state);
        assertEquals(defaultComponentA_not_bound_by_name, defaultComponentB_not_bound_by_name);
    }
}
