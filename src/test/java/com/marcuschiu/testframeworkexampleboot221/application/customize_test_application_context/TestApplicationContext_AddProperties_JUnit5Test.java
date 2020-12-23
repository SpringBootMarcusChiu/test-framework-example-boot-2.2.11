package com.marcuschiu.testframeworkexampleboot221.application.customize_test_application_context;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "turkey=legs")
public class TestApplicationContext_AddProperties_JUnit5Test {
    @Value("${turkey}")
    String foo;

    @Test
    public void test() {
        Assert.assertEquals("legs", foo);
    }
}
