package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboTest {
	public static void main(String[] args) {
		String MonthAndYear= "November 2023";
		int date=20;
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String actual = "//div[text()='September 2023']/ancestor::div[@class='DayPicker-Month']/descendent::p[.='20']";
		String nextArrow = "//span[@aria-label='Next Month']";
		for(;;) {
			try
			{
				driver.findElement(By.xpath(actual)).click();
				break;
			}
			catch(Exception e) 
			{
				driver.findElement(By.xpath(nextArrow)).click();
			}
			driver.findElement(By.xpath("//span[text()='Done']")).click();
		}
	
	}

}
