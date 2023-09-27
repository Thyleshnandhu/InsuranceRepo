package com.ASTL.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Declaration
	@FindBy(name="username")
	private WebElement Username;
	
	@FindBy(name="password")
	private WebElement Password;
	
	@FindBy(xpath = "//button[.='login']")
	private WebElement Submit;
	
	
	//Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Utilization

	public WebElement getUsername() {
		return Username;
	}


	public WebElement getPassword() {
		return Password;
	}


	public WebElement getSubmit() {
		return Submit;
	}
	
	//business library
	public void loginToApp(String uname,String pword)
	{
		Username.sendKeys(uname);
		Password.sendKeys(pword);
		Submit.click();
	}
	

}
