package com.ASTL.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NomineeInfoPage 
{
	@FindBy(xpath = "//a[.='Add Nominee']")
	private WebElement clickAddNominee;
	
	
	public NomineeInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickAddNominee() {
		return clickAddNominee;
	}
	
	
	
	public void clickOnAddNomineeButton()
	{
		clickAddNominee.click();
	}

}
