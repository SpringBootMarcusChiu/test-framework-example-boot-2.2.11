package com.marcuschiu.testframeworkexampleboot221.spring.service;

import org.springframework.stereotype.Service;

@Service
public class Default2Service {

    public Integer greetCount = 0;

    public String greet() {
        System.out.println(getClass().getSimpleName() + "greet() is called");
        greetCount++;
        return "Hello, World";
    }
}