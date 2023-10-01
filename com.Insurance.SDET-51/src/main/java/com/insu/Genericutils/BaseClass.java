package com.insu.Genericutils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.insur.ObjectRespositary.HomePage;
import com.insur.ObjectRespositary.LoginPage;

public class BaseClass {
	
	
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable {
		dLib.connectToDB();
		System.out.println("connect to database");
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable {
		String BROWSER=fLib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		System.out.println("launch the browser");
		sdriver=driver;
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWait(driver, 10);
	}
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME=fLib.getPropertyKeyValue("username");
		String PASSWORD=fLib.getPropertyKeyValue("password");
		
		driver.get(URL);
		
		LoginPage l=new LoginPage(driver);
		l.setLogin(USERNAME, PASSWORD);
		System.out.println("Login to the application");
	}
	@AfterMethod(alwaysRun = true)
	public void configAM() {
		HomePage h= new HomePage(driver);
		h.clickOnLogout();
		System.out.println("signout from the application");
	}
	@AfterClass(alwaysRun = true)
	public void configAC() {
		driver.quit();
		System.out.println("close the browser");
	}
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable {
		dLib.closeDB();
		System.out.println("close DB connection");
	}
	
	
	

}
