package com.marcuschiu.testframeworkexampleboot221.spring.context.springboottest;

import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra1Component;
import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra2Component;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(DefaultDConfiguration.class)
//@SpringBootTest(classes = DefaultDConfiguration.class) // needed as @SpringBootTest doesn't pick up @TestConfiguration automatically
//@ContextConfiguration(classes = {DefaultDConfiguration.class, Extra1Component.class, Extra2Component.class})
public class ContextConfiguration1JUnit4ExampleTest {

    @Autowired
    Extra1Component extra1Component;
    @Autowired
    Extra2Component extra2Component;
    @Autowired
    Tester tester;

    @Test
    public void test() {
        Assert.notNull(extra1Component, "extraComponent is null");
    }
}
