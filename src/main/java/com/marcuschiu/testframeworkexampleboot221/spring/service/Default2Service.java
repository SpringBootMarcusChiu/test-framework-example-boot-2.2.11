package com.marcuschiu.testframeworkexampleboot221.spring.service;

import org.springframework.stereotype.Service;

@Service
public class Default2Service {

    public Integer greetCount = 0;

    public String greet() {
        greetCount++;
        return "Hello, World";
    }
}