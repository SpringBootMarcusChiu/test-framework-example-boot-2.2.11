package com.marcuschiu.testframeworkexampleboot221.junit.before.after;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JUnit5TestInstanceA {

    private int i;

    @BeforeAll
    void beforeAll() {
        // read the file
        i = 0;
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @Test
    void test1() {
        i++;
        System.out.println("test1: " + i);
    }

    @Test
    void test2() {
        System.out.println("test2: " + i);
    }
}
