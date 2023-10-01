package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritingDataToPropertyFileTest {
      public static void main(String[] args) throws Throwable {
		Properties p=new Properties();
		p.setProperty("username", "555");
		p.setProperty("password", "666");
		p.setProperty("url", "http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		p.setProperty("browser", "chrome");
		
		
		FileOutputStream fos=new FileOutputStream("./src\\test\\resources\\CommonData.properties");
		p.store(fos, "write data");
		fos.close();
		
		//reading data
	    FileInputStream fis = new FileInputStream("./src\\test\\resources\\CommonData.properties");
		p.load(fis);
		
		
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		String URL=p.getProperty("url");
		String BROWSER=p.getProperty("browser");
		
		WebDriver  driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
	}
}
