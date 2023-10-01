package com.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsonTest {
	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		FileReader f=new FileReader("./src\\test\\resources\\Jsonread.json");
		JSONParser p=new JSONParser();
		Object obj = p.parse(f);
		
		JSONObject map=(JSONObject)obj;
		
	String	BROWSER=(String)map.get("browser");
	String	URL=(String)map.get("url");
	String	USERNAME=(String)map.get("username");
	String	PASSWORD=(String)map.get("password");
		
		
	/*	System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));*/
	
	System.out.println(BROWSER);
	System.out.println(URL);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
		
		WebDriver  driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
	}

}
