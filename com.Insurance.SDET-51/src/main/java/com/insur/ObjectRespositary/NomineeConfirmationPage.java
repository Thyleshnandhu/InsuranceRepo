package com.insur.ObjectRespositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NomineeConfirmationPage {
	
	//declaration
	@FindBy(xpath="//div[@class='row']")
	private WebElement nomineeconfpage;
	
	//initialization
	public NomineeConfirmationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
    //utilization
	public WebElement getNomineeconfpage() {
		return nomineeconfpage;
	}
	
	

}
