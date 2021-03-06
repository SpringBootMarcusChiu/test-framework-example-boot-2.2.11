package com.marcuschiu.testframeworkexampleboot221.spring.property.activeprofile;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @ActiveProfiles("test") - since both test/resources and main/resources contain
 * application-test.properties. It will read in from test/resources
 */
@SpringBootTest
@ActiveProfiles("test")
public class ActiveProfile1JUnit5ExampleTest {

    @Value("${string.two}")
    String stringTwo;

    @Test
    public void test(){
        Assert.assertEquals("from src/test/resources/application-test.properties", stringTwo);
    }
}