package com.marcuschiu.testframeworkexampleboot221.spring.scheduled;

import com.marcuschiu.testframeworkexampleboot221.spring.scheduled.business.CounterComponent;
import com.marcuschiu.testframeworkexampleboot221.spring.scheduled.business.SchedulingConfig;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @SpringJUnitConfig is a composed annotation that combines both:
 * - @ExtendWith(SpringExtension.class) from JUnit Jupiter (5)
 * - @ContextConfiguration from the Spring TestContext Framework
 */
@SpringJUnitConfig(SchedulingConfig.class)
//@ExtendWith(SpringExtension.class) replaced by @SpringJUnitConfig
//@ContextConfiguration(classes = SchedulingConfig.class) replaced by @SpringJUnitConfig
public class Scheduled1JUnit5Test {

    @Autowired
    CounterComponent counterComponent;

    @Test
    public void givenSleepBy100ms_whenGetInvocationCount_thenIsGreaterThanZero() throws InterruptedException {
        Thread.sleep(100L);
        Assert.assertTrue(counterComponent.getInvocationCount() > 0);
    }
}
