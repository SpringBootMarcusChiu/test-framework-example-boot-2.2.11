package com.marcuschiu.testframeworkexampleboot221.junit.integration;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

/**
 * Integration Test
 * - invoked by `mvn verify` with the maven-failsafe-plugin in the pom.xml
 */
public class Sample1IT {

    @Test
    public void test1() {
        assertTrue(true);
    }

    @Test
    public void test2() {
        assertTrue(true);
    }

    @Test
    public void test3() {
        assertTrue(true);
    }

    @Test
    public void test4() {
        assertTrue(true);
    }
}
