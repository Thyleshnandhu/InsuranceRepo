package com.insurance.ASTL_script;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class AddNomineeScriptTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		//fetch the data from property file
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//READ THE DATA FROM THE EXCEL SHEET
		FileInputStream fi=new FileInputStream("./src\\test\\resources\\TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Nominee");
		int count = sh.getLastRowNum();
		
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
		driver.manage().window().maximize();
		
		//LOGIN TO THE PAGE
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		
		driver.findElement(By.xpath("//a[.='NOMINEE']")).click();
		driver.findElement(By.xpath("//a[.='Add Nominee']")).click();
		
		//ENTER THE MANDATORY FIELDS
		HashMap<String, String> map=new HashMap<String, String>();
		for(int i=1;i<=count;i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key,value);
		}
		for(Entry<String, String> s:map.entrySet())
			
		{
			/*if(s.getKey().contains("client_id")) {*/
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			/*}
			else {
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			}*/
			
			
		}
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		String str=driver.findElement(By.xpath("//div[@class='row']")).getText();
		
		if(str.contains("New Nominee ADDED")) {
			System.out.println("New nominee is added Sucessfully");
			
		}
		else {
			System.out.println("New nominee is not added Successfully");
		}
		
		driver.findElement(By.xpath("//a[@class='btn btn-danger']")).click();
		
		driver.close();
	}

}
