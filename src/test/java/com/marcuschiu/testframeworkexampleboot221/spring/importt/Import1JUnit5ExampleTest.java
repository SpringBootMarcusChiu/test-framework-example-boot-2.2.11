package com.marcuschiu.testframeworkexampleboot221.spring.importt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@Import(ExtraComponent.class)
public class Import1JUnit5ExampleTest {

    @Autowired
    ExtraComponent extraComponent;

    @Test
    public void test() {
        Assert.notNull(extraComponent, "extraComponent is null");
    }
}
