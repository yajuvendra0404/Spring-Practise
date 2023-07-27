package com.learn.OneToOneUniMapping;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToOneUniMappingApplicationTests {

	@Test
	void contextLoads() {
		String message = "no";
		assertEquals(message,"no");
	}
	

}
