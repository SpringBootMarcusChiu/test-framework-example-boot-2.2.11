package com.marcuschiu.testframeworkexampleboot221.mockito.method;

import com.marcuschiu.testframeworkexampleboot221.service.Default1Service;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Mockito1ExampleJUnit5Test {
    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockedValueReturned() {
        Default1Service default1Service = Mockito.mock(Default1Service.class);
        Mockito.when(default1Service.greet()).thenReturn("Jesus Christ");

        String greet = default1Service.greet();

        Assert.assertEquals("Jesus Christ", greet);
        Mockito.verify(default1Service).greet(); // verifies the mocked method was indeed called
    }
}
