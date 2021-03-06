package com.marcuschiu.testframeworkexampleboot221.spring.controller.load.different.levels;

import com.marcuschiu.testframeworkexampleboot221.spring.controller.Default1Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test Whether Controller is loaded into app context
 */
@SpringBootTest
public class Default1Controller0JUnit5Test {

    @Autowired
    Default1Controller controller;

    @Test
    public void contextLoads() {
        assertNotNull(controller);
    }
}
