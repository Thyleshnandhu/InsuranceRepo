package com.insur.ObjectRespositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClientButtonPage {
	//declaration
	@FindBy(xpath="//a[.='Add Client']")
	private WebElement clickonaddclient;
	
	//initialization
	public AddClientButtonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getClickonaddclient() {
		return clickonaddclient;
	}
	//Business Libraries
	public void clickOnClientButton() {
		clickonaddclient.click();
	}
	

	
}
