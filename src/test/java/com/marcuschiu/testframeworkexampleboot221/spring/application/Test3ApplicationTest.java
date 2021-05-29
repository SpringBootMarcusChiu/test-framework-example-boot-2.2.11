package com.marcuschiu.testframeworkexampleboot221.spring.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @SpringBootTest
 * - picks up all classes annotated with @SpringBootApplication/@SpringBootConfiguration
 * - this includes:
 *   - MyApplication.class
 *   - applications/app1/Test1Application.class
 *   - applications/app2/Test2Application.class
 */
@SpringBootTest
class Test3ApplicationTest {

	@Autowired
	ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName: allBeanNames) {
			if (!beanName.contains("org.springframework")) {
				System.out.println(beanName);
			}
		}
	}

}
