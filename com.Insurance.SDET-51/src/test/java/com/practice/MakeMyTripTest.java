package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.navigate().refresh();
	    Actions a= new Actions(driver);
	    a.moveByOffset(0,80).click().perform();
	    Thread.sleep(1000);
	    a.moveByOffset(0, 80).click().perform();
	    driver.findElement(By.xpath("//span[text()='Departure']")).click();
	      String actual = " //div[text()='September']/ancestor: :div[@class='DayPicker-Month']/descendent: :p[.='9']";
	      String nextArrow = "//span[@aria_label='Next Month']";
	      for(;;) {
	      try {
	    	  driver.findElement(By.xpath(actual)).click();
				break;
	      }
	      catch(Exception e) {
                 driver.findElement(By.xpath(nextArrow)).click();
	    	  
	      }
	      driver.findElement(By.xpath("//span[text()='Done']")).click();
	
	}}

}
