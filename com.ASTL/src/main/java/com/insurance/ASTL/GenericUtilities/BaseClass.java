package com.insurance.ASTL.GenericUtilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ASTL.ObjectRepo.HomePage;
import com.ASTL.ObjectRepo.LoginPage;

public class BaseClass 
{
	public DataBaseUtility dlib=new DataBaseUtility();
	public ExcelfileUtility elib=new ExcelfileUtility();
	public FileUtility flib=new FileUtility();
	public WebDriverUtilities wlib=new WebDriverUtilities();
	public JavaUtility jlib=new JavaUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configDB() throws Throwable
	{
		// dlib.connectToDB();
		System.out.println("-- Database connected--");
	}
	
	//@Parameters("BROWSER")
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable
	{
		String BROWSER=flib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("chrome");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			System.out.println("MS Edge");
		}
		else
		{
			System.out.println("invalid browser");
		}
		System.out.println("Browser launched");
		sdriver=driver;
		wlib.maximizeBrowser(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
		String URL=flib.getPropertyKeyValue("url");
		String USERNAME=flib.getPropertyKeyValue("username");
		String PASSWORD=flib.getPropertyKeyValue("password");
		
		driver.get(URL);
		wlib.implicitWait(driver, 10);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login is successful");
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		HomePage h=new HomePage(driver);
		h.clickOnLogout();
		System.out.println("Signout from the application");
		
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable
	{
		// dlib.closeDatabase();
		System.out.println(" Close DB ");
	}

}
