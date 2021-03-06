package com.marcuschiu.testframeworkexampleboot221.spring.property.activeprofile;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @ActiveProfiles("test") - since both only main/resources (not test/resources) contain
 * application-test.properties. It will read in from main/resources
 */
@SpringBootTest
@ActiveProfiles("bogus")
public class ActiveProfile2JUnit5ExampleTest {

    @Value("${string.two}")
    String stringTwo;

    @Test
    public void test(){
        Assert.assertEquals("string two - from src/main/resources/application-bogus.properties", stringTwo);
    }
}