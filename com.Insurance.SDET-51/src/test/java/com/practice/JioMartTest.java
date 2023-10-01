package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartTest {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.jiomart.com/");
	WebElement a = driver.findElement(By.xpath("//a[.='Groceries']"));
	Actions ac=new Actions(driver);
	ac.moveToElement(a).perform();
	WebElement b = driver.findElement(By.xpath("//a[.='Fruits & Vegetables']"));
	ac.moveToElement(b).perform();
	String d = driver.findElement(By.xpath("(//ul[@class='header-nav-l3 custom-scrollbar'])[1]")).getText();
	System.out.println(d);
	
}
}
