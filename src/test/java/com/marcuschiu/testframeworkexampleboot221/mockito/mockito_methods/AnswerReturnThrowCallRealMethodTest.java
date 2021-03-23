package com.marcuschiu.testframeworkexampleboot221.mockito.mockito_methods;

import com.marcuschiu.testframeworkexampleboot221.spring.service.Default1Service;
import com.marcuschiu.testframeworkexampleboot221.spring.service.Default2Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnswerReturnThrowCallRealMethodTest {

    @Mock
    Default1Service serviceMock;

    @Spy
    Default2Service serviceSpy;

    @Test
    public void test1() {
        // .greet() is not actually called
        when(serviceMock.greet()).thenReturn("Mock Response");
        assertEquals("Mock Response", serviceMock.greet());

        // .greet() is actually called
        when(serviceSpy.greet()).thenReturn("Mock Response");
        assertEquals("Mock Response", serviceSpy.greet());
    }

    @Test
    public void test2() {
        // .greet() called once
        when(serviceMock.repeat(any())).thenAnswer(invocation -> invocation.callRealMethod() + " mocked");
        assertEquals("something mocked", serviceMock.repeat("something"));

        // .greet() called twice
        when(serviceSpy.repeat(any())).thenAnswer(invocation -> invocation.callRealMethod() + " mocked");
        assertEquals("something mocked", serviceSpy.repeat("something"));
    }

    @Test
    public void test3() {
        // .greet() not called
        when(serviceMock.repeat(any())).thenThrow(new RuntimeException("Mock Exception"));
        Exception exception1 = assertThrows(RuntimeException.class, () -> serviceMock.repeat("d"));
        assertEquals("Mock Exception", exception1.getMessage());

        // .greet() actually called
        when(serviceSpy.repeat(any())).thenThrow(new RuntimeException("Mock Exception"));
        Exception exception2 = assertThrows(RuntimeException.class, () -> serviceSpy.repeat("d"));
        assertEquals("Mock Exception", exception2.getMessage());
    }

    @Test
    public void test4() {
        // .greet() called once
        when(serviceMock.greet()).thenCallRealMethod();
        assertEquals("Hello, World", serviceMock.greet());

        // .greet() called twice
        when(serviceSpy.greet()).thenCallRealMethod();
        assertEquals("Hello, World", serviceSpy.greet());
    }
}
