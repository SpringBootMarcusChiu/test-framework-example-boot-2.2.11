package com.marcuschiu.testframeworkexampleboot221.junit.mockito.runners;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import com.marcuschiu.testframeworkexampleboot221.spring.service.Default2Service;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @RunWith(SpringJUnit4ClassRunner.class)
 * @RunWith(SpringRunner.class)
 * - allows @MockBean
 * - provides support for loading a Spring ApplicationContext and having
 *   beans @Autowired into your test instance
 */
@DirtiesContext // used because (@SpyBean Default2Service) state changes and is reused in other tests
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

    @SpyBean
    Default2Service default2Service;

    @Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        Default2Service default2ServiceFromContext = context.getBean(Default2Service.class);

        default2ServiceFromContext.greet();

        Mockito.verify(default2ServiceFromContext).greet();

        assertEquals(1, default2ServiceFromContext.greetCount);
    }
}
