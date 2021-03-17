package com.marcuschiu.testframeworkexampleboot221.mockito;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import com.marcuschiu.testframeworkexampleboot221.spring.service.Default2Service;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @RunWith(MockitoJUnitRunner.class) - enables use of @Mock
 */
@RunWith(MockitoJUnitRunner.class)
public class M2_Annotations_Runner_JUnit4Test {

    /**
     * @Mock - replaces Default1Service default1Service = Mockito.mock(Default1Service.class);
     */
    @Mock
    Default1Service default1Service;

    @org.junit.Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockedValueReturned() {
        // replaced by @Mock above
//        Default1Service default1Service = Mockito.mock(Default1Service.class);

        // replaced with @RunWith(MockitoJUnitRunner.class)
//        MockitoAnnotations.initMocks(this);

        Mockito.when(default1Service.greet()).thenReturn("Jesus Christ");

        String greet = default1Service.greet();

        Assert.assertEquals("Jesus Christ", greet);
        Mockito.verify(default1Service).greet(); // verifies the mocked method was indeed called
    }

    @Spy
    Default2Service default2Service;

    @org.junit.Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        // replaced with @RunWith(MockitoJUnitRunner.class)
//        MockitoAnnotations.initMocks(this);

        // exercise
        default2Service.greet();

        // behavior verification - default2ServiceFromContext is a Test Spy
        // - Meszaros refers to stubs that use behavior verification as a Test Spy
        Mockito.verify(default2Service).greet();
        // state verification - default2ServiceFromContext is a stub
        assertEquals(1, default2Service.greetCount);


        // stubbing spy
        Mockito.when(default2Service.toString()).thenReturn("Jesus Christ");
        // exercise and verify stub
        assertEquals("Jesus Christ", default2Service.toString());
    }
}
