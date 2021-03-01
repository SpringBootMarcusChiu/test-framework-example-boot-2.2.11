package com.marcuschiu.testframeworkexampleboot221.testconfiguration;

import com.marcuschiu.testframeworkexampleboot221.testconfiguration.config.DefaultComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @EnableAutoConfiguration - used to bootstrap classes annotated with @Configuration @TestConfiguration classes
 * @ExtendWith(SpringExtension.class) - used to bootstrap Spring application context, allowing @Autowired
 * @ComponentScan - tells you where to find the configuration classes
 */
@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = "com.marcuschiu.testframeworkexampleboot221.testconfiguration.config")
public class TestConfiguration1_Test {

    @Autowired
    DefaultComponent defaultComponentA;

    @Autowired
    DefaultComponent defaultComponentB;

    @Test
    public void test() {
        assertEquals("created from @TestConfiguration", defaultComponentA.state);
        assertEquals("created from @Configuration", defaultComponentB.state);
    }
}
