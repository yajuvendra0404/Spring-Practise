package com.learn.OneToOneUniMapping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToOneUniMappingApplicationTests {

	@Test
	void contextLoads() {
		String message = "gogood";
		assertEquals(message,"gogood");
		System.out.println("---- test demo is ending ----");
//		fail("fialed the test.");
	}
	

}
