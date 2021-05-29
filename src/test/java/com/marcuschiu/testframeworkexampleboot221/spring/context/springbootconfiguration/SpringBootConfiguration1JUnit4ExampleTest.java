package com.marcuschiu.testframeworkexampleboot221.spring.context.springbootconfiguration;

import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra1Component;
import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra2Component;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * @SpringBootTest - will automatically pickup classes annotated with:
 * - @SpringBootConfiguration
 * - @SpringBootApplication
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfiguration1JUnit4ExampleTest {

    @Autowired
    Extra1Component extra1Component;
    @Autowired
    Extra2Component extra2Component;

    @Test
    public void test() {
        Assert.notNull(extra1Component, "extraComponent is null");
    }
}
