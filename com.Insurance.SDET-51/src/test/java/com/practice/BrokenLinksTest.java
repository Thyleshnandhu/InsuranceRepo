package com.practice;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ksrtc.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		ArrayList<String> links = new ArrayList<String>();
		for(int i=0;i<allLinks.size();i++) {
			URL url=null;
			int statuscode=0;
			String eachLink=allLinks.get(i).getAttribute("href");
			try {
				URL u=new URL(eachLink);
				HttpsURLConnection https=(HttpsURLConnection)u.openConnection();
				statuscode = https.getResponseCode();
				if(statuscode>=400) {
					links.add(eachLink);
				}
			
		}
			catch(Exception e) {
			}
			}
		int bCount=links.size();
		System.out.println("Broken links are : "+bCount);
		for (String s : links) {
			System.out.println(s);
			
	}
	}
}
