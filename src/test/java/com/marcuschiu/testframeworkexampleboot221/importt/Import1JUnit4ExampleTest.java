package com.marcuschiu.testframeworkexampleboot221.importt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@Import(ExtraComponent.class)
public class Import1JUnit4ExampleTest {

    @Autowired
    ExtraComponent extraComponent;

    @Test
    public void test() {
        Assert.notNull(extraComponent, "extraComponent is null");
    }
}
