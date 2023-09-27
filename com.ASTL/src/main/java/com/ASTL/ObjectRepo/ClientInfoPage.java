package com.ASTL.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientInfoPage 
{
	@FindBy(linkText = "Add Client")
	private WebElement Addclient;
	
	

	@FindBy(xpath = "//td[.='1666847453']/../td[7]/a")
	private WebElement selectclient;
	
	
	public ClientInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectclient() {
		return selectclient;
	}
	

	public WebElement getAddclient() {
		return Addclient;
	}
	
	//Business library
	public void clickOnAddClientButton()
	{
		Addclient.click();
	}
	

	public void clickOnSelectedCLient()
	{
		selectclient.click();
	}


}
