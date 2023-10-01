package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccCricketTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		//String match = driver.findElement(By.xpath("//span[.='India']/../following-sibling::td[1]")).getText();
		//driver.findElement(By.xpath("//span[.='Team']"));
		    List<WebElement> teams = driver.findElements(By.xpath("//tr/td[2]"));
		    List<WebElement> matches = driver.findElements(By.xpath("//tr/td[2]/../td[3]"));
		    for(int i=0; i<matches.size();i++) {
		    	String totalTeam = teams.get(i).getText();
		    	String matchText = matches.get(i).getText();
		    	int totalMatch=Integer.parseInt(matchText);
			if(totalMatch<40) {
		        System.out.println(totalTeam+"-->"+totalMatch);
		  }
		 }
		    driver.close();
}
}