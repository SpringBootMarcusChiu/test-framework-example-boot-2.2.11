package com.marcuschiu.testframeworkexampleboot221.other.async;

import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static org.awaitility.Awaitility.await;
import static org.awaitility.Awaitility.fieldIn;
import static org.hamcrest.Matchers.equalTo;

public class AsyncServiceTest {
    private AsyncService asyncService;

    @Before
    public void setUp() {
        asyncService = new AsyncService();
    }

    @Test
    public void test1() {
        asyncService.initialize();
        await().until(asyncService::isInitialized);
    }

    @Test
    public void test2() {
        asyncService.initialize();
        await()
            .atLeast(Duration.ofMillis(100))
            .atMost(Duration.ofSeconds(5))
          .with()
            .pollInterval(Duration.ofMillis(100))
            .until(asyncService::isInitialized);
    }

    @Test
    public void test_using_hamcrest_matchers() {
        asyncService.initialize();
        await().until(asyncService::isInitialized);

        long value = 5;
        asyncService.addValue(value);
        await().until(asyncService::getValue, equalTo(value)); // hamcrest.Matchers.equalTo
    }

    @Test
    public void test_ignore_exception() {
        asyncService.initialize();
        await()
            .ignoreException(IllegalStateException.class)
            .until(asyncService::getValue, equalTo(0L));
    }

    @Test
    public void test_accessing_private_fields() {
        asyncService.initialize();
        await()
            .until(fieldIn(asyncService)
                .ofType(boolean.class)
                .andWithName("initialized"), equalTo(true));
    }
}
