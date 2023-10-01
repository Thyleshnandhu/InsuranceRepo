package com.insurance.ASTL_script;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.insu.Genericutils.BaseClass;
import com.insu.Genericutils.DatabaseUtility;
import com.insu.Genericutils.ExcelUtility;
import com.insu.Genericutils.FileUtility;
import com.insu.Genericutils.JavaUtility;
import com.insu.Genericutils.WebDriverUtility;
import com.insur.ObjectRespositary.AddNomineeButtonPage;
import com.insur.ObjectRespositary.CreateNomineePage;
import com.insur.ObjectRespositary.HomePage;
import com.insur.ObjectRespositary.LoginPage;

public class AddNomineeFromPomTest extends BaseClass{
	@Test
	public void addNominee() throws Throwable {
		
		
	
		
		//WebDriver driver=null;
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
		
		//pom class
	    LoginPage l=new LoginPage(driver);
		l.setLogin(USERNAME, PASSWORD);
		
	    //CLICK ON THE NOMINEE MODULE  
		HomePage h=new HomePage(driver);
		h.clickOnNominee();
        
		//CLICK ON THE NOMINEE BUTTON
		AddNomineeButtonPage a=new AddNomineeButtonPage(driver);
		a.clickOnNomineeButton();
		
	    Assert.fail();
		
		//ENTER THE MANDATORY FIELDS
		CreateNomineePage c=new CreateNomineePage(driver);
		c.nomineePage(eLib.getMultipleDataFromExcel("Nominee", 0, 1, driver), driver);
		//eLib.getMultipleDataFromExcel("Nominee", 0, 1, driver);
		
		
		CreateNomineePage c1= new CreateNomineePage(driver);
		c1.enterSubmitBtn();
		
		
		
		
		String str=driver.findElement(By.xpath("//div[@class='row']")).getText();
		
		if(str.contains("New Nominee ADDED")) {
			System.out.println("New nominee is added Sucessfully");
			
		}
		else {
			System.out.println("New nominee is not added Successfully");
		}
		
		driver.findElement(By.xpath("//a[@class='btn btn-danger']")).click();
		//String exp="New Nominee ADDED";
		//String actual=driver.getTitle();
		//System.out.println(actual);
		//SoftAssert s=new SoftAssert();
		//s.assertEquals(actual,exp);
		
	//	driver.close();

	

}
}