package com.marcuschiu.testframeworkexampleboot221.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Default1ServiceTest {

    @Autowired
    Default1Service default1Service;

    @Test
    public void test() {
        assertEquals(default1Service.greet(), "Hello, World");
    }
}
