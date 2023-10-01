package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KabbadiTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    //launch the browser
		driver.get("https://www.prokabaddi.com/");
		//click on the standings
		driver.findElement(By.xpath("//span[text()='Standings']")).click();
		WebElement a = driver.findElement(By.xpath("(//div[@class='row-head'])[1]"));
		
		System.out.println(a);
	}

}
