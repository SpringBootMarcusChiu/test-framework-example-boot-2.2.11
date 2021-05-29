package com.marcuschiu.testframeworkexampleboot221.spring.context.componentscans;

import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra1Component;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@ComponentScans({
        @ComponentScan(basePackages = "com.marcus.example"),
        @ComponentScan(basePackageClasses = Extra1Component.class)
})
class ComponentScans1JUnit5ExampleTest {

    @Autowired
    Extra1Component extra1Component;

    @Test
    void test() {
        Assert.notNull(extra1Component, "extraComponent is null");
    }
}
