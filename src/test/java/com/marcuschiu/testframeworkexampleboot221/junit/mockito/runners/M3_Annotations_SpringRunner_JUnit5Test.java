package com.marcuschiu.testframeworkexampleboot221.junit.mockito.runners;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @ExtendWith(SpringExtension.class)
 * - tells JUnit 5 to enable Spring support
 * - allows @MockBean
 */
@ExtendWith(SpringExtension.class)
public class M3_Annotations_SpringRunner_JUnit5Test {

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
