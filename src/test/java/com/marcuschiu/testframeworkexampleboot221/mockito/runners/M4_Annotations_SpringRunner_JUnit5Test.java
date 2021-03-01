package com.marcuschiu.testframeworkexampleboot221.mockito.runners;

import com.marcuschiu.testframeworkexampleboot221.service.Default1Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @ExtendWith(SpringExtension.class)
 * - tells JUnit 5 to enable Spring support
 * - allows @MockBeans/@MockBean
 */
@ExtendWith(SpringExtension.class)
@MockBeans({
        @MockBean(Default1Service.class)
})
public class M4_Annotations_SpringRunner_JUnit5Test {

    // REPLACED BY ABOVE
//    /**
//     * @MockBean - adds mock bean to the applicationContext
//     */
//    @MockBean
//    Default1Service default1Service;

    @Autowired
    ApplicationContext context;

    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
        Default1Service default1ServiceFromContext = context.getBean(Default1Service.class);
        String greeting = default1ServiceFromContext.greet();
        // greeting should be void
    }
}
