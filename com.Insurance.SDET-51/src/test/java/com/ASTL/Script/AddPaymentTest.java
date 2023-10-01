package com.ASTL.Script;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.insu.Genericutils.DatabaseUtility;

import com.insu.Genericutils.ExcelUtility;

import com.insu.Genericutils.FileUtility;

import com.insu.Genericutils.JavaUtility;

import com.insu.Genericutils.WebDriverUtility;
import com.insur.ObjectRespositary.LoginPage;


public class AddPaymentTest {
     public static void main(String[] args) throws Throwable {
    	 WebDriver driver = new ChromeDriver();
    	 DatabaseUtility dLib=new DatabaseUtility();
 		FileUtility fLib= new FileUtility();
 		ExcelUtility eLib=new ExcelUtility();
 		JavaUtility jLib= new JavaUtility();
 		WebDriverUtility wLib=new WebDriverUtility();
 		
 		//FETCH THE DATA FROM PROPERTY FILE
 		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		        //FETCH THE DATA FROM EXCEL FILE
			/**	FileInputStream fi=new FileInputStream("./src\\test\\resources\\TestData1.xlsx");
				Workbook wb=WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet("Payment");
				int count=sh.getLastRowNum();**/
		
		//LANUCH THE BROWSER
		if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
			 }
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		
		//MAXIMIZE THE BROWSER
		wLib.maximizeTheBrowser(driver);
		
 		//ENTER THE URL
 		driver.get(URL);
 		
 		//IMPLICIT WAIT
 		wLib.implicitWait(driver, 10);
 		
 		//LOGIN TO THE BROWSER
 	/**	driver.findElement(By.name("username")).sendKeys(USERNAME);
 		driver.findElement(By.name("password")).sendKeys(PASSWORD);
 		driver.findElement(By.xpath("//button[.='login']")).click();**/
 		
 		//LOGIN TO THE BROWSER
 		//POM CLASS
 				LoginPage l=new LoginPage(driver);
 				l.setLogin(USERNAME, PASSWORD);
 		
 		
 		
 		
 		driver.findElement(By.xpath("//a[.='CLIENTS']")).click();
 		JavascriptExecutor j=(JavascriptExecutor)driver;
 		 for(int i=0;i<8;i++) {
 		    	j.executeScript("window.scrollBy(0,10000)");
 		    	
 		 }
 		 driver.findElement(By.xpath("(//a[.='Client Status'])[351]")).click();

 		JavascriptExecutor js=(JavascriptExecutor)driver;
 		 for(int x=0;x<4;x++) {
 		    	js.executeScript("window.scrollBy(0,400)");
 		    	}
 		 driver.findElement(By.xpath("//a[.='Add Payment']")).click(); 
 		 
 		/** driver.findElement(By.name("month")).sendKeys("March");
 		 driver.findElement(By.name("amount")).sendKeys("1000");
 		 driver.findElement(By.name("due")).sendKeys("0");
 		 driver.findElement(By.name("fine")).sendKeys("0");**/
 		
 		eLib.getMultipleDataFromExcel("payment", 0, 1, driver);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
 		 
 		 String str = driver.findElement(By.xpath("//div[@class='row']")).getText();
 			
 			if(str.contains("New Payment ADDED")){
 				
 			 
 				System.out.println("Payment  is added suscessfully");
 			}
 			else {
 				System.out.println("Payment  is not added suscessfully");
 			}
 		
	}
}
