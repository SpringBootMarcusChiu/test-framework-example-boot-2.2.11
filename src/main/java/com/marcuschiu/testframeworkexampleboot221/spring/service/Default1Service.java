package com.marcuschiu.testframeworkexampleboot221.spring.service;

import org.springframework.stereotype.Service;

@Service
public class Default1Service {

    public String greet() {
        System.out.println(getClass().getSimpleName() + "greet() is called");
        return "Hello, World";
    }

    public String repeat(final String str) {
        System.out.println(getClass().getSimpleName() + "clone() is called");
        return str;
    }
}
