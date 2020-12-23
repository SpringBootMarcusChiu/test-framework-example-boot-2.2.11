package com.marcuschiu.testframeworkexampleboot221._applicationcontext;

import com.marcuschiu.testframeworkexampleboot221.config.PropertyUsingComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertNotNull;

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
