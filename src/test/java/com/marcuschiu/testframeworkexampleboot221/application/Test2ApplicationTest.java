package com.marcuschiu.testframeworkexampleboot221.application;

import com.marcuschiu.testframeworkexampleboot221.applications.app2.Test2Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @SpringBootTest(classes = Test2Application.class)
 * - scans only the current package and subpages of Test2Application.class
 */
@SpringBootTest(classes = Test2Application.class)
class Test2ApplicationTest {

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
