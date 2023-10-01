package com.ASTL.Script;

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
import com.insur.ObjectRespositary.DeleteClientsPage;
import com.insur.ObjectRespositary.EditClientPage;
import com.insur.ObjectRespositary.HomePage;
import com.insur.ObjectRespositary.LoginPage;

public class DeleteClientTest {
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
			
			HomePage h=new HomePage(driver);
			h.clickOnClient();
	
			JavascriptExecutor j=(JavascriptExecutor)driver;
			 for(int i=0;i<8;i++) {
			    	j.executeScript("window.scrollBy(0,10000)");
			    	
			 }
			 EditClientPage d=new EditClientPage(driver);
			 d.clickOnEdit();
			 
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 for(int x=0;x<4;x++) {
			    	js.executeScript("window.scrollBy(0,400)");
		}
			 DeleteClientsPage q=new  DeleteClientsPage(driver);
			 q.clickOnTheDeleteLink();
			 
			 String str = driver.findElement(By.xpath("//div[@class='row']")).getText();
				
				if(str.contains("Client deleted successfully")){
					
				 
					System.out.println("Client  is deleted suscessfully");
				}
				else {
					System.out.println("Client  is not deleted suscessfully");
				}
			
			

}}
