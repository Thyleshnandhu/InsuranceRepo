package com.ASTL.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.insurance.ASTL.GenericUtilities.BaseClass;

public class AddNomineePage {
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement clickSubmit;
	
	public AddNomineePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickSubmit() {
		return clickSubmit;
	}
	
	
	public void getDataForClient(HashMap<String, String>map, WebDriver driver)
	{
		for(Entry<String, String> s:map.entrySet())
		{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
	}
	
	
	public void clickOnNomineeSubmit()
	{
		clickSubmit.click();
	}

}
