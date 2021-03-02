package com.marcuschiu.testframeworkexampleboot221.ignore.disable;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class IgnoreJUnit4Test {

    @Test
    public void test() {
        System.out.println("hello world");
    }
}
