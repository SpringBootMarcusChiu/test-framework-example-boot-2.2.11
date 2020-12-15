package com.marcuschiu.testframeworkexampleboot221;

import com.marcuschiu.testframeworkexampleboot221.config.PropertyUsingComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
class MyApplicationTests {

	@Autowired
	PropertyUsingComponent propertyUsingComponent;

	@Test
	void contextLoads() {
		assertNotNull(propertyUsingComponent);
	}

}
