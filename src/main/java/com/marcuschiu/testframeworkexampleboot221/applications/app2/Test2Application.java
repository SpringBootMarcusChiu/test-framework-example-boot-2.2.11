package com.marcuschiu.testframeworkexampleboot221.applications.app2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Test2Application {

    @Bean
    public String helloWorld2() {
        return "Hello, World!";
    }
}
