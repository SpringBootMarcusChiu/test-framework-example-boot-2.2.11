package com.marcuschiu.testframeworkexampleboot221.spring.context.testconfiguration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultBConfiguration {

    @Bean
    public DefaultComponent defaultComponentB() {
        return new DefaultComponent("created from @Configuration");
    }
}
