package com.marcuschiu.testframeworkexampleboot221.spring.context.componentscans;

import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra1Component;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@ComponentScans({
        @ComponentScan(basePackages = "com.marcus.example"),
        @ComponentScan(basePackageClasses = Extra1Component.class)
})
public class ComponentScans1JUnit4ExampleTest {

    @Autowired
    Extra1Component extra1Component;

    @Test
    public void test() {
        Assert.notNull(extra1Component, "extraComponent is null");
    }
}
