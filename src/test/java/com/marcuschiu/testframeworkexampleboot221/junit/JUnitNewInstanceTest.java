package com.marcuschiu.testframeworkexampleboot221.junit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * For each test method JUnit creates a new instance of the test class
 */
public class JUnitNewInstanceTest {

    private final List<String> list = new ArrayList<>();
    private static final List<String> staticList = new ArrayList<>();

    @Test
    public void testFirst() {
        list.add("one");
        assertEquals(1, list.size());

        staticList.add("one");
        assertEquals(1, staticList.size());
    }

    @Test
    public void testSecond() {
        assertEquals(0, list.size());
        assertEquals(1, staticList.size());
    }
}