package com.marcuschiu.testframeworkexampleboot221.junit.timeout;

import org.junit.Test;

public class JUnit4Test {

    @Test(timeout = 1000)
    public void givenExecution_takeMoreTime_thenFail() {
        while (true);
    }
}
