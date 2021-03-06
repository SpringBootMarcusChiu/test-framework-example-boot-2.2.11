package com.marcuschiu.testframeworkexampleboot221.junit.mockito.runners;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
        Mockito.when(default1Service.greet()).thenReturn("Jesus Christ");

        String greet = default1Service.greet();

        Assert.assertEquals("Jesus Christ", greet);
        Mockito.verify(default1Service).greet(); // verifies the mocked method was indeed called
    }
}
