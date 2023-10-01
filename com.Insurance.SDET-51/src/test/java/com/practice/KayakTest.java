package com.practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KayakTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    //lanuch the browser
	    driver.get("https://www.kayak.co.in/");
	    //Selecting the place(from)
	     driver.findElement(By.xpath("//div[@class='k_my k_my-mod-theme-mcfly-search k_my-mod-radius-base k_my-mod-size-large k_my-mod-font-size-base k_my-mod-spacing-default k_my-mod-text-overflow-ellipsis k_my-mod-state-default']")).click();
	    //Selecting the place(to)
	    driver.findElement(By.xpath("(//input[@class='k_my-input'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@class='PVIO-input'])[1]")).click();
	    //selecting the date(departure)
	    driver.findElement(By.xpath("//span[@class='sR_k-date']")).click();
        driver.findElement(By.xpath("(//div[text()='4'])[1]")).click();
        //selecting the date(return)
        driver.findElement(By.xpath("(//span[@class='tUEz-icon'])[2]")).click();
        driver.findElement(By.xpath("(//div[text()='11'])[1]")).click();
        //selecting adult
         driver.findElement(By.xpath("//span[text()='1 adult']")).click();
        WebElement adult = driver.findElement(By.xpath("(//button[@class='bCGf-mod-theme-default'])[1]"));
        for(int i=0;i<5;i++) {
        	adult.click();
        }
        //search the ticket
 driver.findElement(By.xpath("//button[@class='Iqt3 Iqt3-mod-bold Button-No-Standard-Style Iqt3-mod-variant-solid Iqt3-mod-theme-progress Iqt3-mod-shape-rounded-medium Iqt3-mod-shape-mod-default Iqt3-mod-spacing-default Iqt3-mod-size-large Iqt3-mod-animation-search']")).click();
 
 Set<String> a = driver.getWindowHandles();
 for(String b:a) {
	 driver.switchTo().window(b);
	 driver.findElement(By.xpath("//div[text()='Other sort']")).click();
 }
 
/* driver.findElement(By.xpath("//div[text()='Other sort']")).click();*/
	}

}
