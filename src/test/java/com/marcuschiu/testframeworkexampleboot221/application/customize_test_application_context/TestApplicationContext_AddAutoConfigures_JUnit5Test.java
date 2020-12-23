package com.marcuschiu.testframeworkexampleboot221.application.customize_test_application_context;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class TestApplicationContext_AddAutoConfigures_JUnit5Test {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test() {
        Assert.assertNotNull(mockMvc);
    }
}
