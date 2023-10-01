package com.insurance.ASTL_script;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddClientScriptTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		//FETCH THE DATA FROM PROPERTY FILE
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//FETCH THE DATA FROM EXCEL FILE
		FileInputStream fi=new FileInputStream("./src\\test\\resources\\TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Client");
		int count=sh.getLastRowNum();
		
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
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
	    HashMap<String, String> map=new HashMap<String, String>();
	    for(int i=1;i<=count;i++) {
	    	String key=sh.getRow(i).getCell(0).getStringCellValue();
	    	String value=sh.getRow(i).getCell(1).getStringCellValue();
	    	map.put(key,value);
	    }
	    for(Entry<String, String> s:map.entrySet()) {
	    	driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
	    	
	    }
	    
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
	
		
	}

}
