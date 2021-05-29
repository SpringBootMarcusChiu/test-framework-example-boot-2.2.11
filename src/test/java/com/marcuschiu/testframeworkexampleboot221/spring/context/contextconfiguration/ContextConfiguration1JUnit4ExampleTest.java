package com.marcuschiu.testframeworkexampleboot221.spring.context.contextconfiguration;

import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra1Component;
import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra2Component;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

/**
 * @ContextConfiguration -
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Extra1Component.class)
@Import(Extra2Component.class)
public class ContextConfiguration1JUnit4ExampleTest {

    @Autowired
    Extra1Component extra1Component;
    @Autowired
    Extra2Component extra2Component;

    @Test
    public void test() {
        Assert.notNull(extra1Component, "extraComponent is null");
    }
}
