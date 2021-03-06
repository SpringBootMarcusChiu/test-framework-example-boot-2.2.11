package com.marcuschiu.testframeworkexampleboot221.spring.scheduled;

import com.marcuschiu.testframeworkexampleboot221.spring.scheduled.business.CounterComponent;
import com.marcuschiu.testframeworkexampleboot221.spring.scheduled.business.SchedulingConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @RunWith(SpringJUnit4ClassRunner.class)
 * @RunWith(SpringRunner.class)
 * - provides support for loading a Spring ApplicationContext and having
 *   beans @Autowired into your test instance
 * - both are used for bridging between Spring Boot test features and JUnit 4
 * - whenever we are using any Spring Boot testing features in our JUnit 4 tests,
 *   this annotation will be required
 * @ContextConfiguration
 * - used to determine how to load and configure an
 *   ApplicationContext in integration tests
 */
//@RunWith(SpringRunner.class) is an alias for SpringJUnit4ClassRunner.class
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SchedulingConfig.class)
public class Scheduled1JUnit4Test {

    @Autowired
    CounterComponent counterComponent;

    @Test
    public void givenSleepBy100ms_whenGetInvocationCount_thenIsGreaterThanZero() throws InterruptedException {
        Thread.sleep(100L);
        Assert.assertTrue(counterComponent.getInvocationCount() > 0);
    }
}
