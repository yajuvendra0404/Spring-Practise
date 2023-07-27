package testing;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JUnitTest {


	@Test
	public void test_JUnit () {
		System.out.println("---- test demo is working ----");
		String message = "springsadkjsdfsimple";
		assertEquals(message,"nooooo simple12");
		System.out.println("---- test demo is ending ----");
	}
//	public static void main(String a[]) {
//		JUnitTest jut = new JUnitTest();
//		jut.demo();
//	}
}
