package com.marcuschiu.testframeworkexampleboot221.mockito;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

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
    List<String> spyList = new ArrayList<>();

    @org.junit.Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        // replaced with @RunWith(MockitoJUnitRunner.class)
//        MockitoAnnotations.initMocks(this);

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());

        // stubbing spy
        Mockito.when(spyList.toString()).thenReturn("Jesus Christ");
        // verify stub
        assertEquals("Jesus Christ", spyList.toString());
    }
}
