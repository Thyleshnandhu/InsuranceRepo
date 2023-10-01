package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccRankingTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		  List<WebElement> coun = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/span[2]"));
		String s="Scotland";
		int count=0;
		int tcount= coun.size();
		for (int i=0;i<tcount;i++) {
			String t=coun.get(i).getText();
			if(t.contains(s)) {
				count++;
			}
		}
		if(count>0) {
			System.out.println("scotland is present");
		}
		else {
			System.out.println("scotland is not present");
		}
		driver.quit();
	}

}
