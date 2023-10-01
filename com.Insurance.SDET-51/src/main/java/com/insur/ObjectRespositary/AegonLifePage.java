package com.insur.ObjectRespositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AegonLifePage {
	//declaration
	@FindBy(xpath="//a[.='Aegon Life']")
	private WebElement aegonlife;
	
	//initialization
	public AegonLifePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getAegonlife() {
		return aegonlife;
	}
	
	public void clickOnAegonLife() {
		aegonlife.click();
	}
	

}
