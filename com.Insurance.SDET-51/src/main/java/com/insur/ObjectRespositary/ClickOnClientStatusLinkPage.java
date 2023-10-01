package com.insur.ObjectRespositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnClientStatusLinkPage {
	
	//declaration
	@FindBy(xpath="//a[.='Client Status']")
    private WebElement clickClientStatus;
	
	//initialization
	public ClickOnClientStatusLinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	//utilization
	public WebElement getClickClientStatus() {
		return clickClientStatus;
	}
	
	//business libraries
	 public void clickOnClientStatus() {
	    	clickClientStatus.click();

}
}
