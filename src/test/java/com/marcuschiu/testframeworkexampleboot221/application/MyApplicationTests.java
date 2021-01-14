package com.marcuschiu.testframeworkexampleboot221.application;

import com.marcuschiu.testframeworkexampleboot221.applications.app1.Test1Application;
import com.marcuschiu.testframeworkexampleboot221.config.PropertyUsingComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * @SpringBootTest
 * - scans everything basically (including components/beans in the entire test package
 */
@SpringBootTest
class MyApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	PropertyUsingComponent propertyUsingComponent;

	@Test
	void contextLoads() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName: allBeanNames) {
			if (!beanName.contains("org.springframework")) {
				System.out.println(beanName);
			}
		}
		assertNotNull(propertyUsingComponent);
	}

}
