package TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

public class HardAssertTest {
	@Test
	public void hardassertTest() {
		System.out.println("Step-1");
		System.out.println("Step-2");
		assertEquals("A", "B");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	@Test
	public void hardassertTest2() {
		System.out.println("Step-5");
		System.out.println("Step-6");
		assertNotEquals("X", "X");
		System.out.println("Step-7");
		System.out.println("Step-8");
	}
	@Test
	public void hardassertTest3() {
		int n=5;
		assertNotNull(n);
		System.out.println("Step-9");
	}
	

}
