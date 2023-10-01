package com.insurance.ASTL_script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.insu.Genericutils.DatabaseUtility;
import com.insu.Genericutils.ExcelUtility;
import com.insu.Genericutils.FileUtility;
import com.insu.Genericutils.JavaUtility;
import com.insu.Genericutils.WebDriverUtility;
import com.insur.ObjectRespositary.AddPaymentButtonPage;
import com.insur.ObjectRespositary.AegonLifePage;
import com.insur.ObjectRespositary.ClientDoPaymentPage;
import com.insur.ObjectRespositary.HomePage;
import com.insur.ObjectRespositary.LoginPage;

public class ClientDoPaymentFromPomTest {
	public static void main(String[] args) throws Throwable {
		
		
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
        //maximize the browser
		wLib.maximizeTheBrowser(driver);
		driver.get(URL);
		wLib.implicitWait(driver, 10);
		//LOGIN TO THE BROWSER
		//POM CLASS
				LoginPage l=new LoginPage(driver);
				l.setLogin(USERNAME, PASSWORD);
				
				AegonLifePage a= new AegonLifePage(driver);
				a.clickOnAegonLife();
				
				HomePage h2=new HomePage(driver);
				h2.clickOnPayment();
				
				AddPaymentButtonPage a1=new AddPaymentButtonPage(driver);
				a1.clickOnPaymentLink();
				driver.findElement(By.name("client_id")).sendKeys("1694069091");
				
				ClientDoPaymentPage c1=new ClientDoPaymentPage(driver);
				c1.createPayment(eLib.getMultipleDataFromExcel("payment", 0, 1, driver), driver);
				//eLib.getMultipleDataFromExcel("payment", 0, 1, driver);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				HomePage h1=new HomePage(driver);
				h1.clickOnLogout();

}
}