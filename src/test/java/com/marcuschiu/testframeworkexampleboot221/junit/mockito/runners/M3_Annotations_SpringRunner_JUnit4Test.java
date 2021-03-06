package com.marcuschiu.testframeworkexampleboot221.junit.mockito.runners;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @RunWith(SpringJUnit4ClassRunner.class)
 * @RunWith(SpringRunner.class)
 * - allows @MockBean
 * - provides support for loading a Spring ApplicationContext and having
 *   beans @Autowired into your test instance
 */
@RunWith(SpringRunner.class)
public class M3_Annotations_SpringRunner_JUnit4Test {

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
