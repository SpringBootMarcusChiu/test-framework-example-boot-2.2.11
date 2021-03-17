package com.marcuschiu.testframeworkexampleboot221.mockito;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M1_Manual_JUnit4Test {
    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockedValueReturned() {
        Default1Service default1Service = Mockito.mock(Default1Service.class);
        Mockito.when(default1Service.greet()).thenReturn("Jesus Christ");

        String greet = default1Service.greet();

        Assert.assertEquals("Jesus Christ", greet);
        Mockito.verify(default1Service).greet(); // verifies the mocked method was indeed called
    }

    @org.junit.Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        List<String> spyList = Mockito.spy(ArrayList.class);

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
