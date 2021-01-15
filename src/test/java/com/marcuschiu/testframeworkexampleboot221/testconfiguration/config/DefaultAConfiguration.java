package com.marcuschiu.testframeworkexampleboot221.testconfiguration.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class DefaultAConfiguration {

    @Bean
    public DefaultComponent defaultComponentA() {
        return new DefaultComponent("created from @TestConfiguration");
    }
}
