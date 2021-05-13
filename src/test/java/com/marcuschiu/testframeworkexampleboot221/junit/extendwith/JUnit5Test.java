package com.marcuschiu.testframeworkexampleboot221.junit.extendwith;

import com.marcuschiu.testframeworkexampleboot221.config.PropertyUsingComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Import(PropertyUsingComponent.class)
@ExtendWith({SpringExtension.class, ExampleExtension.class})
class JUnit5Test {

    @Autowired
    private PropertyUsingComponent propertyUsingComponent;

    @Test
    void test1() {
        System.out.println("PropertyUsingComponent.getStringOne(): string.one = " + propertyUsingComponent.getStringOne());
    }

    @Test
    void test2() {
        System.out.println("PropertyUsingComponent.getStringOne(): string.one = " + propertyUsingComponent.getStringOne());
    }
}
