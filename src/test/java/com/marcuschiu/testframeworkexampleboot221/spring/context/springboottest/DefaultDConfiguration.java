package com.marcuschiu.testframeworkexampleboot221.spring.context.springboottest;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class DefaultDConfiguration {

    @Bean
    public Tester tester() {
        return new Tester("created from @ContextConfiguration");
    }
}
