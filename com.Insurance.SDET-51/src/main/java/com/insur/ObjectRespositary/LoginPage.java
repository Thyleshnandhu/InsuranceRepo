package com.insur.ObjectRespositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	@FindBy(name="username")
	private WebElement UserNamebx;
	
	@FindBy(name="password")
	private WebElement Passwordbx;
	
	@FindBy(xpath="//button[.='login']")
	private WebElement Lgbx;
	
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUserNamebx() {
		return UserNamebx;
	}

	public WebElement getPasswordbx() {
		return Passwordbx;
	}

	public WebElement getLgbx() {
		return Lgbx;
	}
	
	//Business Libraries
	
	public void setLogin(String un,String pw) {
		UserNamebx.sendKeys(un);
		Passwordbx.sendKeys(pw);
		Lgbx.click();
	}}


