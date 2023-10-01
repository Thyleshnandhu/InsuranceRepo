package TestNG;

import org.testng.annotations.Test;

public class PracticeTest {
	@Test
	public void createTest() {
		/**int[]x = {1,2,3};
		System.out.println(x[5]);**/
		System.out.println("data is created");
		
	}
	
	@Test (dependsOnMethods = "createTest")
	public void editTest() {
		System.out.println("data modfication is done");
	}
	@Test(priority=2, invocationCount= 1)
	public void deleteTest() {
		System.out.println("data deleted sucessfully");
	}

}
