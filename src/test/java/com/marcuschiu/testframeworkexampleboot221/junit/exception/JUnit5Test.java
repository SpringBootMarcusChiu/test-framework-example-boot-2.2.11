package com.marcuschiu.testframeworkexampleboot221.junit.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JUnit5Test {

    @Test
    public void whenDividerIsZero_thenDivideByZeroExceptionIsThrown() {
        Calculator calculator = new Calculator();
        assertThrows(DivideByZeroException.class, () -> calculator.divide(10, 0));
    }
}
