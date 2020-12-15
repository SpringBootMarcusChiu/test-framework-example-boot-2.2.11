package com.marcuschiu.testframeworkexampleboot221.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyUsingComponent {

    @Value("${string.one}")
    String stringOne;

    @Value("${string.two}")
    String stringTwo;

    @Value("${string.three}")
    String stringThree;

    public String getStringOne() {
        return stringOne;
    }

    public String getStringTwo() {
        return stringTwo;
    }

    public String getStringThree() {
        return stringThree;
    }
}
