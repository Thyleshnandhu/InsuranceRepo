package com.insur.ObjectRespositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPaymentButtonPage {
	//declaration
	@FindBy(xpath="//a[.='Add Payment']")
	private WebElement addPaymentLink;
	
	//initialization
	public AddPaymentButtonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getAddPaymentLink() {
		return addPaymentLink;
	}
	//Business Libraries
	public void clickOnPaymentLink() {
		addPaymentLink.click();
	}

}
