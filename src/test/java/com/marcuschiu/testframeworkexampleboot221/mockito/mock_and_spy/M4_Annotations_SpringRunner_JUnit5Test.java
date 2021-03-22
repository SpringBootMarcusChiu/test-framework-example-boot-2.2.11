package com.marcuschiu.testframeworkexampleboot221.mockito.mock_and_spy;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import com.marcuschiu.testframeworkexampleboot221.spring.service.Default2Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.mock.mockito.SpyBeans;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ExtendWith(SpringExtension.class)
 * - tells JUnit 5 to enable Spring support
 * - allows @MockBeans/@MockBean
 */
@DirtiesContext // used because (@SpyBean Default2Service) state changes and is reused in other test
@ExtendWith(SpringExtension.class)
@MockBeans({
        @MockBean(Default1Service.class)
})
@SpyBeans({
        @SpyBean(Default2Service.class)
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

    // REPLACED BY ABOVE
//    @SpyBean
//    Default2Service default2Service;

    @Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        Default2Service default2ServiceFromContext = context.getBean(Default2Service.class);

        // exercise
        default2ServiceFromContext.greet();

        // behavior verification - default2ServiceFromContext is a Test Spy
        // - Meszaros refers to stubs that use behavior verification as a Test Spy
        Mockito.verify(default2ServiceFromContext).greet();
        // state verification - default2ServiceFromContext is a stub
        assertEquals(1, default2ServiceFromContext.greetCount);


        // stubbing spy
        Mockito.when(default2ServiceFromContext.toString()).thenReturn("Jesus Christ");
        // exercise and verify stub
        assertEquals("Jesus Christ", default2ServiceFromContext.toString());
    }
}
