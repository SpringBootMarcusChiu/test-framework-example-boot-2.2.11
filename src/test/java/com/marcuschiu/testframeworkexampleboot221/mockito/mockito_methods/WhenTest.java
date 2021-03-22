package com.marcuschiu.testframeworkexampleboot221.mockito.mockito_methods;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import com.marcuschiu.testframeworkexampleboot221.spring.service.Default2Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WhenTest {

    @Spy
    Default1Service serviceSpy;
    @Mock
    Default2Service serviceMock;

    @Test
    public void test1() {
        // .greet() will actually be called
        when(serviceSpy.greet()).thenReturn("Mock Response");
        assertEquals("Mock Response", serviceSpy.greet());

        // .greet() will NOT actually be called
        when(serviceMock.greet()).thenReturn("Mock Response");
        assertEquals("Mock Response", serviceMock.greet());
    }

    @Test
    public void test2() {
        // .greet() will NOT actually be called
        doReturn("Mock Response").when(serviceSpy).greet();
        assertEquals("Mock Response", serviceSpy.greet());

        // .greet() will NOT actually be called
        doReturn("Mock Response").when(serviceMock).greet();
        assertEquals("Mock Response", serviceMock.greet());
    }
}
