package com.insur.ObjectRespositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditClientPage {
	
	@FindBy(xpath="(//a[.='Edit'])[351]")
	private WebElement editlink;
	
	//initialiazation
	public EditClientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getEditlink() {
		return editlink;
	}
	public void clickOnEdit() {
		editlink.click();
	}

}
