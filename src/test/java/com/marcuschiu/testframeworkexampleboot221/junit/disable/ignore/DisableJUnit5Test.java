package com.marcuschiu.testframeworkexampleboot221.junit.disable.ignore;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Example Disable")
public class DisableJUnit5Test {
    @Test
    public void test() {
        System.out.println("hello world");
    }
}
