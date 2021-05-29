package com.marcuschiu.testframeworkexampleboot221.spring.context.importt;

import com.marcuschiu.testframeworkexampleboot221.spring.context.Extra1Component;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@Import(Extra1Component.class)
public class Import1JUnit5ExampleTest {

    @Autowired
    Extra1Component extra1Component;

    @Test
    public void test() {
        Assert.notNull(extra1Component, "extraComponent is null");
    }
}
