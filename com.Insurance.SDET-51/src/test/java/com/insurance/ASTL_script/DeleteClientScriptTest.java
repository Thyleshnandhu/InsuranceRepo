package com.insurance.ASTL_script;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteClientScriptTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("username")).sendKeys("555");
		driver.findElement(By.name("password")).sendKeys("666");
		driver.findElement(By.xpath("//button[.='login']")).click();
		driver.findElement(By.xpath("//a[.='CLIENTS']")).click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		 for(int i=0;i<8;i++) {
		    	j.executeScript("window.scrollBy(0,10000)");
		    	
		 }
		 driver.findElement(By.xpath("(//a[.='Edit'])[351]")).click();
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 for(int x=0;x<4;x++) {
		    	js.executeScript("window.scrollBy(0,400)");
	}
		 driver.findElement(By.xpath("//a[.='Delete Client']")).click();
		 String str = driver.findElement(By.xpath("//div[@class='row']")).getText();
			
			if(str.contains("Client deleted successfully")){
				
			 
				System.out.println("Client  is deleted suscessfully");
			}
			else {
				System.out.println("Client  is not deleted suscessfully");
			}
	}
}


