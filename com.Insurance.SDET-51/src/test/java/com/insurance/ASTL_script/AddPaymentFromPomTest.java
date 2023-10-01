package com.insurance.ASTL_script;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.insu.Genericutils.BaseClass;
import com.insu.Genericutils.DatabaseUtility;
import com.insu.Genericutils.ExcelUtility;
import com.insu.Genericutils.FileUtility;
import com.insu.Genericutils.JavaUtility;
import com.insu.Genericutils.WebDriverUtility;
import com.insur.ObjectRespositary.AddPaymentButtonPage;
import com.insur.ObjectRespositary.AddPaymentPage;

import com.insur.ObjectRespositary.ClickOnClientStatusLinkPage;
import com.insur.ObjectRespositary.HomePage;
import com.insur.ObjectRespositary.LoginPage;

public class AddPaymentFromPomTest extends BaseClass {
	@Test
	public void addPayment() throws Throwable {
		
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
		
		
	/**	driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();**/
		//POM CLASS
		//LOGIN TO THE BROWSER
		LoginPage l=new LoginPage(driver);
		l.setLogin(USERNAME, PASSWORD);
		
		//ENTER THE CLIENT MODULE
		HomePage h=new HomePage(driver);
		h.clickOnClient();
		
		JavascriptExecutor j=(JavascriptExecutor)driver;
		 for(int i=0;i<8;i++) {
		    	j.executeScript("window.scrollBy(0,10000)");
		    	
		 }
		//ENTER THE CLIENT STATUS LINK
		 ClickOnClientStatusLinkPage c=new ClickOnClientStatusLinkPage(driver);
		 c.clickOnClientStatus();
		 
		// driver.findElement(By.xpath("(//a[.='Client Status'])[351]")).click();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		 for(int x=0;x<4;x++) {
		    	js.executeScript("window.scrollBy(0,400)");
		    	}
		 
		 
		// driver.findElement(By.xpath("//a[.='Add Payment']")).click(); 
		 //CLICK ON THE PAYMENT LINK
		 AddPaymentButtonPage a=new AddPaymentButtonPage(driver);
		 a.clickOnPaymentLink();
		 
		//ENTER MANDATORY FIELDS 
		 AddPaymentPage a1=new AddPaymentPage(driver);
		 a1.createPayment(eLib.getMultipleDataFromExcel("payment", 0, 1,driver), driver);
		 
			 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//VALIDATION
		 
		 String str = driver.findElement(By.xpath("//div[@class='row']")).getText();
			
			if(str.contains("New Payment ADDED")){
				
			 
				System.out.println("Payment  is added suscessfully");
			}
			else {
				System.out.println("Payment  is not added suscessfully");
			}
		
	}
}


