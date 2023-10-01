package com.insurance.ASTL_script;

import org.openqa.selenium.By;
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
import com.insur.ObjectRespositary.AddClientButtonPage;
import com.insur.ObjectRespositary.ClientConfirmationPage;
import com.insur.ObjectRespositary.CreateClientPage;
import com.insur.ObjectRespositary.HomePage;
import com.insur.ObjectRespositary.LoginPage;

public class AddClientFromPomTest extends BaseClass {
	@Test(groups="smoke")
	public void createclienttest() throws Throwable {
		
		WebDriver driver=null;
		DatabaseUtility dLib=new DatabaseUtility();
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		//FETCH THE DATA FROM PROPERTY FILE
		
		String BROWSER =fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		
		//LAUNCH THE BROWSER
		if(BROWSER.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		wLib.maximizeTheBrowser(driver);
		
		driver.get(URL);
		
		wLib.implicitWait(driver, 10);
		
		
		//POM CLASS
		LoginPage l=new LoginPage(driver);
		l.setLogin(USERNAME, PASSWORD);
		
		HomePage h=new HomePage(driver);
		h.clickOnClient();
		//driver.findElement(By.xpath("//a[.='CLIENTS']")).click();
		//driver.findElement(By.xpath("//a[.='Add Client']")).click();
		AddClientButtonPage a=new AddClientButtonPage(driver);
		a.clickOnClientButton();
		
		
	
		
	    //ENTER THE MANDATORY FIELDS
		CreateClientPage c=new CreateClientPage(driver);
		c.createClient(eLib.getMultipleDataFromExcel("Client", 0, 1,driver), driver);
		
		//eLib.getMultipleDataFromExcel("Client", 0, 1, driver);
	 
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	    //VALIDATE THE STATEMENT
	  
		 String str = driver.findElement(By.xpath("//div[@class='row']")).getText();
		
		if(str.contains("New Client ADDED")) {
			System.out.println("client is added suscessfully");
		}
		else {
			System.out.println("client is not added suscessfully");
		}
	
		//LOGOUT 
		HomePage h1=new HomePage(driver);
		h1.clickOnLogout();
       
		
		driver.close();	
	}

}
