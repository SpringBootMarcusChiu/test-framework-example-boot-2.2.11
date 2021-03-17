package com.marcuschiu.testframeworkexampleboot221.junit.mockito.runners;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ExtendWith(MockitoExtension.class) - enables use of @Mock
 */
@ExtendWith(MockitoExtension.class)
public class M2_Annotations_Runner_JUnit5Test {

    /**
     * @Mock - replaces Default1Service default1Service = Mockito.mock(Default1Service.class);
     */
    @Mock
    Default1Service default1Service;

    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockedValueReturned() {
        // line below is replaced by @Mock above
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

    @Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        // replaced with @RunWith(MockitoJUnitRunner.class)
//        MockitoAnnotations.initMocks(this);

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());
    }
}
