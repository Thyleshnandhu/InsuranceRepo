package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJetTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    //launch the browser
	    driver.get("https://www.spicejet.com/");
	    //clicking on the roundtrip
	   driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-117bsoe r-1otgn73'][2]")).click();
	   //selecting the place(from)
	  WebElement a = driver.findElement(By.xpath("//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'][1]"));
	  a.click();
	  a.sendKeys("Bengaluru");
	  //selecting the place(to)
	 WebElement b = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-qsz3a2 r-adyw6z r-1kfrs79']/ancestor::div[@class='css-1dbjc4n r-b5h31w r-95jzfe']/descendant::div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79'][15]"));
	 b.click();
	  driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']")).click();
     driver.findElement(By.xpath("//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar']")).click();
     driver.findElement(By.xpath("(//div[text()='2'])[1]")).click();
     driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73'])[1]")).click();
     driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).click();
     driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")).click();
     driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41'])[73]")).click();
     driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
    WebElement c = driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid'])[1]"));
     for(int i=0;i<5;i++) {
     	c.click();
     	
     }
     driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
	}
}
