package com.marcuschiu.testframeworkexampleboot221.junit.before.after;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class JUnit5TestInstanceB {

    private static int i;

    @BeforeAll
    static void beforeAll() {
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
        i++;
        System.out.println("test2: " + i);
    }
}
