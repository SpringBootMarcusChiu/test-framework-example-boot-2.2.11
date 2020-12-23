package com.marcuschiu.testframeworkexampleboot221.applications.app1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Test1Application {

    @Bean
    public String helloWorld1() {
        return "Hello, World!";
    }
}
