package com.insur.ObjectRespositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientConfirmationPage {
    //declaration
	@FindBy(xpath="//div[@class='row']")
	private WebElement clientConfirmpage;
	
	//initialization
	public ClientConfirmationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getClientConfirmpage() {
		return clientConfirmpage;
	}
	//business libraries
	public void displayConfirmationPage() {
		clientConfirmpage.isDisplayed();
	}
	
	
}
