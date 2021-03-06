package com.marcuschiu.testframeworkexampleboot221.junit.exception;

public class DivideByZeroException extends RuntimeException {
    public DivideByZeroException(String e) {
        super(e);
    }
}