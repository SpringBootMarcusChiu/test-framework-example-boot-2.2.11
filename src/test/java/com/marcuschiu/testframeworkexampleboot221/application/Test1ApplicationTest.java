package com.marcuschiu.testframeworkexampleboot221.application;

import com.marcuschiu.testframeworkexampleboot221.applications.app1.Test1Application;
import com.marcuschiu.testframeworkexampleboot221.config.PropertyUsingComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * @SpringBootTest(classes = Test1Application.class)
 * - scans only the current package and subpages of Test1Application.class
 */
@SpringBootTest(classes = Test1Application.class)
class Test1ApplicationTest {

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
