package com.marcuschiu.testframeworkexampleboot221.mockito;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M2_Annotations_Initializer_JUnit5Test {

    /**
     * @Mock - replaces Default1Service default1Service = Mockito.mock(Default1Service.class);
     */
    @Mock
    Default1Service default1Service;

    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockedValueReturned() {
        // line below is replaced by @Mock above
//        Default1Service default1Service = Mockito.mock(Default1Service.class);

        // Initializes @Mock default1Service
        MockitoAnnotations.initMocks(this);

        Mockito.when(default1Service.greet()).thenReturn("Jesus Christ");

        String greet = default1Service.greet();

        Assert.assertEquals("Jesus Christ", greet);
        Mockito.verify(default1Service).greet(); // verifies the mocked method was indeed called
    }

    @Spy
    List<String> spyList = new ArrayList<>();

    @Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        MockitoAnnotations.initMocks(this);

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());
    }
}
