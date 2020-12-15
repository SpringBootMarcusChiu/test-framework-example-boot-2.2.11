package com.marcuschiu.testframeworkexampleboot221.mockito.annotation;

import com.marcuschiu.testframeworkexampleboot221.service.Default1Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @RunWith(SpringRunner.class) - allows @MockBean
 */
@RunWith(SpringRunner.class)
public class MockBean1ExampleJUnit4Test {

    /**
     * @MockBean - adds mock bean to the applicationContext
     */
    @MockBean
    Default1Service default1Service;

    @Autowired
    ApplicationContext context;

    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
        Mockito.when(default1Service.greet()).thenReturn("Jesus Christ");

        Default1Service default1ServiceFromContext = context.getBean(Default1Service.class);
        String greeting = default1ServiceFromContext.greet();

        Assert.assertEquals("Jesus Christ", greeting);
        Mockito.verify(default1Service).greet();
    }
}