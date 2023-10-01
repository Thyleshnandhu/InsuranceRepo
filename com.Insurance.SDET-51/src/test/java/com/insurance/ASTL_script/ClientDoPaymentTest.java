package com.insurance.ASTL_script;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClientDoPaymentTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("555");
		driver.findElement(By.name("password")).sendKeys("666");
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		driver.findElement(By.xpath("//a[.='Aegon Life']")).click();
	    String payCount = driver.findElement(By.xpath("//div[@class='main-box mb-dull']/descendant::h5")).getText();
	    System.out.println("Before adding payment the count is:"+payCount);
		
		driver.findElement(By.xpath("//a[.='PAYMENTS']")).click();
		driver.findElement(By.xpath("//a[.='Add Payment']")).click();
		driver.findElement(By.name("client_id")).sendKeys("1694069091");
	    driver.findElement(By.name("month")).sendKeys("September");
	    driver.findElement(By.name("amount")).sendKeys("100");
	    driver.findElement(By.name("due")).sendKeys("0");
	    driver.findElement(By.name("fine")).sendKeys("0");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	   
	    String str = driver.findElement(By.xpath("//div[@class='row']")).getText();
		if(str.contains("New Payment ADDED")){
			System.out.println("Payment is done suscessfully");
		}
		else {
			System.out.println("Payment is not done suscessfully");
		}
	    
	    
	    driver.findElement(By.xpath("//a[.='Aegon Life']")).click();
	    String payCount1 = driver.findElement(By.xpath("//div[@class='main-box mb-dull']/descendant::h5")).getText();
	    System.out.println("After adding payment the count is:"+payCount1);
	}

}
