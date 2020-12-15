package com.marcuschiu.testframeworkexampleboot221.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ExtendWith(SpringExtension.class) is not needed with @SpringBootTest
 */
//@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Default1ServiceJUnit5Test {

    @Autowired
    Default1Service default1Service;

    @Test
    public void test() {
        assertEquals(default1Service.greet(), "Hello, World");
    }
}
