package com.marcuschiu.testframeworkexampleboot221.spring.scheduled.business;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan("com.marcuschiu.testframeworkexampleboot221.spring.scheduled.business")
public class SchedulingConfig {
}
