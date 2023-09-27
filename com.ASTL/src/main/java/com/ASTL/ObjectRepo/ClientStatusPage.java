package com.ASTL.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientStatusPage 
{
	
	@FindBy(linkText = "Add Payment")
	private WebElement clickaddpayment;
	
	
	public ClientStatusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickaddpayment() {
		return clickaddpayment;
	}
	
	
	public void clickOnAddPayemnt()
	{
		clickaddpayment.click();
	}
	
	
	
	

}
