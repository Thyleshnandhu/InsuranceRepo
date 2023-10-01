package com.ASTL.Script;

import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.insu.Genericutils.DatabaseUtility;

import com.insu.Genericutils.ExcelUtility;

import com.insu.Genericutils.FileUtility;

import com.insu.Genericutils.JavaUtility;

import com.insu.Genericutils.WebDriverUtility;


public class AddNomineeTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		DatabaseUtility dLib=new DatabaseUtility();
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
	   //fetch the data from property file
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		//LAUNCH THE BROWSER
		if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
			 }
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		//maximize the browser
		wLib.maximizeTheBrowser(driver);
		
		//LOGIN TO THE PAGE
		driver.get(URL);
		
		wLib.implicitWait(driver, 10);
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		driver.findElement(By.xpath("//a[.='NOMINEE']")).click();
		driver.findElement(By.xpath("//a[.='Add Nominee']")).click();
		
		//ENTER THE MANDATORY FIELDS
		eLib.getMultipleDataFromExcel("Nominee", 0, 1, driver);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		String str=driver.findElement(By.xpath("//div[@class='row']")).getText();
		
		if(str.contains("New Nominee ADDED")) {
			System.out.println("New nominee is added Sucessfully");
			
		}
		else {
			System.out.println("New nominee is not added Successfully");
		}
		
		driver.findElement(By.xpath("//a[@class='btn btn-danger']")).click();
		
		driver.close();
	}
}
