package com.insur.ObjectRespositary;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNomineePage {
	
	//declaration
	@FindBy(name="nominee_id")
	private WebElement nomineebx;
	
	@FindBy(name="client_id")
	private WebElement clientbx;
	
	@FindBy(name="name")
	private WebElement namebx;
	
	@FindBy(name="sex")
	private WebElement genderbx;
	
	@FindBy(name="birth_date")
	private WebElement birthbx;
	
	@FindBy(name="nid")
	private WebElement nidbx;
	
	@FindBy(name="relationship")
	private WebElement relationbx;
	
	@FindBy(name="priority")
	private WebElement prioritybx;
	
	@FindBy(name="phone")
	private WebElement phonebx;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitbt;
	
	//initialization
	public CreateNomineePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//utilization

	public WebElement getNomineebx() {
		return nomineebx;
	}

	public WebElement getClientbx() {
		return clientbx;
	}

	public WebElement getNamebx() {
		return namebx;
	}

	public WebElement getGenderbx() {
		return genderbx;
	}

	public WebElement getBirthbx() {
		return birthbx;
	}

	public WebElement getNidbx() {
		return nidbx;
	}

	public WebElement getRelationbx() {
		return relationbx;
	}

	public WebElement getPrioritybx() {
		return prioritybx;
	}

	public WebElement getPhonebx() {
		return phonebx;
	}

	public WebElement getSubmitbt() {
		return submitbt;
	}
	//Business Libraries
	public void nomineePage (HashMap<String, String> map, WebDriver driver ) {
		
	/**	HashMap<String , String> map=new HashMap<String, String>();**/
		  for(Entry<String, String> s:map.entrySet()) 
		   {
				   driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			   }
		  
		  }
	public void enterSubmitBtn() {
		submitbt.click();
	  }

}
