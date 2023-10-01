package com.ASTL.Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.insu.Genericutils.DatabaseUtility;

import com.insu.Genericutils.ExcelUtility;

import com.insu.Genericutils.FileUtility;

import com.insu.Genericutils.JavaUtility;

import com.insu.Genericutils.WebDriverUtility;


public class AddClientTest {
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
		wLib.maximizeTheBrowser(driver);
		
		driver.get(URL);
		
		wLib.implicitWait(driver, 10);
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		driver.findElement(By.xpath("//a[.='CLIENTS']")).click();
		driver.findElement(By.xpath("//a[.='Add Client']")).click();
		
		
	/*	driver.findElement(By.name("client_password")).sendKeys("Nandhu@1998");
		driver.findElement(By.name("name")).sendKeys("Nandhini");*/
	   /* WebElement a = driver.findElement(By.name("fileToUpload"));
	    a.sendKeys("C:\\Users\\prasad\\Desktop\\cat4.jpg");*/
		
	/*	driver.findElement(By.name("sex")).sendKeys("female");
		driver.findElement(By.name("birth_date")).sendKeys("18/09/1999");
		driver.findElement(By.name("maritial_status")).sendKeys("unmarried");
		driver.findElement(By.name("nid")).sendKeys("12345");
		driver.findElement(By.name("phone")).sendKeys("9087654321");
		driver.findElement(By.name("address")).sendKeys("BTM Layout");
		driver.findElement(By.name("policy_id")).sendKeys("5678");
		
		driver.findElement(By.name("nominee_name")).sendKeys("prasad");
		driver.findElement(By.name("nominee_sex")).sendKeys("male");
		driver.findElement(By.name("nominee_birth_date")).sendKeys("19/09/1996");
		driver.findElement(By.name("nominee_nid")).sendKeys("9089");
		driver.findElement(By.name("nominee_relationship")).sendKeys("brother");
		driver.findElement(By.name("priority")).sendKeys("high");
		driver.findElement(By.name("nominee_phone")).sendKeys("9807654321");*/
		
	    //ENTER THE MANDATORY FIELDS
		eLib.getMultipleDataFromExcel("Client", 0, 1, driver);
	  /**  HashMap<String, String> map=new HashMap<String, String>();
	    for(int i=1;i<=count;i++) {
	    	String key=sh.getRow(i).getCell(0).getStringCellValue();
	    	String value=sh.getRow(i).getCell(1).getStringCellValue();
	    	map.put(key,value);
	    }
	    for(Entry<String, String> s:map.entrySet()) {
	    	driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
	    	
	    }**/
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
        driver.findElement(By.xpath("//a[@class='btn btn-danger']")).click();
		
		driver.close();		
}}
