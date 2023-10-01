package com.insur.ObjectRespositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNomineeButtonPage {
	
	//declaration
	@FindBy(xpath="//a[.='Add Nominee']")
	private WebElement addNomineebx;
	
	//initialization
	public AddNomineeButtonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getAddNomineebx() {
		return addNomineebx;
	}
	
	//Business Libraries
	public void clickOnNomineeButton() {
		addNomineebx.click();
	}
	
	
	
	
	

}
