package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void softassertTest() {
		WebDriver driver= new ChromeDriver();
		String exp="Login Page";
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		String actual=driver.getTitle();
		System.out.println(actual);
		SoftAssert s=new SoftAssert();
		s.assertEquals(actual,exp);
		System.out.println("appliaction launched");
		System.out.println("execution ended");
		s.assertAll();
		
	}

}
