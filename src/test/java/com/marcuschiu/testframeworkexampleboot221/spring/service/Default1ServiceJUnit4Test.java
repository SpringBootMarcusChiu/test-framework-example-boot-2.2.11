package com.marcuschiu.testframeworkexampleboot221.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Default1ServiceJUnit4Test {

    @Autowired
    Default1Service default1Service;

    @Test
    public void test() {
        assertEquals(default1Service.greet(), "Hello, World");
    }
}
