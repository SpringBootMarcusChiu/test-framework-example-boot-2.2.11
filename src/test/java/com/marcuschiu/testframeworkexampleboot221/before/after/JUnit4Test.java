package com.marcuschiu.testframeworkexampleboot221.before.after;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnit4Test {

    private static List<Integer> numbers;

    @BeforeClass
    public static void initialize() {
        System.out.println("@BeforeClass");
        numbers = new ArrayList<>();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("@AfterClass");
        numbers = null;
    }

    @Before
    public void runBeforeEachTest() {
        System.out.println("@Before");
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @After
    public void runAfterEachTest() {
        System.out.println("@After");
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
