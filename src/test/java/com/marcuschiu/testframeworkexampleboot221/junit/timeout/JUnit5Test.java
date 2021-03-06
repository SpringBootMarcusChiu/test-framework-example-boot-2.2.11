package com.marcuschiu.testframeworkexampleboot221.junit.timeout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class JUnit5Test {
    @Test
    public void givenExecution_takeMoreTime_thenFail() {
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(2000));
    }
}
