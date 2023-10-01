package com.insur.ObjectRespositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteClientsPage {
	@FindBy(xpath="//a[.='Delete Client']")
	private WebElement deleteclient;
	
	//initialization
	public DeleteClientsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getDeleteclient() {
		return deleteclient;
	}
	public void clickOnTheDeleteLink() {
		deleteclient.click();
	}
	
	

}
