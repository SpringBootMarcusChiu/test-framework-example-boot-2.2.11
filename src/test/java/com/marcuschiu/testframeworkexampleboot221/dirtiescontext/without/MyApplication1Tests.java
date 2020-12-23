package com.marcuschiu.testframeworkexampleboot221.dirtiescontext.without;

import com.marcuschiu.testframeworkexampleboot221.dirtiescontext.TestComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyApplication1Tests {

	@Autowired
	TestComponent testComponent;

	@Test
	void contextLoads() {
		System.out.println(testComponent.i.addAndGet(1));
	}
}
