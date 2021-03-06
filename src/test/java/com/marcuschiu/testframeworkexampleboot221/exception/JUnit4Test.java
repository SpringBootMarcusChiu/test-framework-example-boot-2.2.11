package com.marcuschiu.testframeworkexampleboot221.exception;

import org.junit.Test;

public class JUnit4Test {

    @Test(expected = DivideByZeroException.class)
    public void whenDividerIsZero_thenDivideByZeroExceptionIsThrown() {
        Calculator calculator = new Calculator();
        calculator.divide(10, 0);
    }
}
