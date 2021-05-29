package com.marcuschiu.testframeworkexampleboot221.spring.context.springbootconfiguration;

import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra1Component;
import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra2Component;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * @SpringBootTest - will automatically pickup classes annotated with:
 * - @SpringBootConfiguration
 * - @SpringBootApplication
 */
@SpringBootTest
class SpringBootConfiguration1JUnit5ExampleTest {

    @Autowired
    Extra1Component extra1Component;
    @Autowired
    Extra2Component extra2Component;

    @Test
    void test() {
        Assert.notNull(extra1Component, "extraComponent is null");
    }
}
