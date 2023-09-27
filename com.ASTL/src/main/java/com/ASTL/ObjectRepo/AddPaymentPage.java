package com.ASTL.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPaymentPage 
{
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement clicksubmit;
	
	public AddPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}

	public WebElement getClicksubmit() {
		return clicksubmit;
	}
	
	
	public void clickOnPaymentSubmitButton()
	{
		clicksubmit.click();
	}

}
