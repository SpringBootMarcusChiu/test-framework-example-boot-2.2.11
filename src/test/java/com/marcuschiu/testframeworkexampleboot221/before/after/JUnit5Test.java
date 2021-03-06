package com.marcuschiu.testframeworkexampleboot221.before.after;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnit5Test {

    private static List<Integer> numbers;

    @BeforeAll
    public static void initialize() {
        System.out.println("@BeforeAll");
        numbers = new ArrayList<>();
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("@AfterAll");
        numbers = null;
    }

    @BeforeEach
    public void runBeforeEachTest() {
        System.out.println("@BeforeEach");
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @AfterEach
    public void runAfterEachTest() {
        System.out.println("@AfterEach");
        numbers.clear();
    }

    @Test
    public void givenNumbers_sumEquals_thenCorrect() {
        System.out.println("Test 1");
        int sum = numbers.stream().reduce(0, Integer::sum);
        assertEquals(6, sum);
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }
}
