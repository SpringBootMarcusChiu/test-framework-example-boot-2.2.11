package com.marcuschiu.testframeworkexampleboot221.spring.annotation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @EnableScheduling
 * - enables @Scheduled
 * @EnableAspectJAutoProxy
 * - enables @Aspect, replaces @Import(AnnotationAwareAspectJAutoProxyCreator.class)
 * @ExtendWith(SpringExtension.class)
 * - SpringExtension class is provided by Spring 5 and integrates the Spring
 *   TestContext Framework into JUnit 5
 * - enables you to use Spring test framework features in your tests
 *   like for example: @MockBean, @Autowired, etc
 * @ContextConfiguration (classes = {..})
 * -
 */
@EnableScheduling
@EnableAspectJAutoProxy
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { FeatureToggleAspect.class, FeatureToggleAspectTest.DefaultComponent.class })
public class FeatureToggleAspectTest {

    @Autowired
    DefaultComponent defaultComponent;

    @Test
    public void test1() {
        DefaultComponent.isModified = false;
        defaultComponent.modify();
        Assert.assertEquals(false, DefaultComponent.isModified);
    }

    @Test
    public void test2() throws InterruptedException {
        DefaultComponent.isModified = false;
        Thread.sleep(1500); // let @Scheduled invoke defaultComponent.modify();
        Assert.assertEquals(true, DefaultComponent.isModified);
    }

    @Component
    public static class DefaultComponent {

        public static Boolean isModified = false;

        @Scheduled(cron = "*/1 * * * * *")
        @FeatureToggle(feature = "Hello, World")
        public void modify() {
            isModified = true;
        }
    }
}
