package com.insur.ObjectRespositary;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateClientPage {
	//declaration
	@FindBy(name="client_id")
	private WebElement clientid;
	
	@FindBy(name="client_password")
	private WebElement clientpw;
	
	@FindBy(name="name")
	private WebElement namebx;
	
	@FindBy(name="fileToUpload")
	private WebElement fileupbx;
	
	@FindBy(name="sex")
	private WebElement genderbx;
	
	@FindBy(name="birth_date")
	private WebElement birdatebx;
	
	@FindBy(name="maritial_status")
	private WebElement statusbx;
	
	@FindBy(name="nid")
	private WebElement nidbx;
	
	@FindBy(name="phone")
	private WebElement phonebx;
	
	@FindBy(name="address")
	private WebElement addressbx;
	
	@FindBy(name="policy_id")
	private WebElement policybx;
	
	@FindBy(name="agent_id")
	private WebElement agentidbx;
	
	@FindBy(name="nominee_id")
	private WebElement nomineebx;
	
	@FindBy(name="nominee_name")
	private WebElement nomineenamebx;
	
	@FindBy(name="nominee_sex")
	private WebElement genderbx1;
	
	@FindBy(name="nominee_birth_date")
	private WebElement nomibirthbx;
	
	@FindBy(name="nominee_nid")
	private WebElement nomineenidbx;
	
	@FindBy(name="nominee_relationship")
	private WebElement nomirelationbx;
	
	@FindBy(name="priority")
	private WebElement prioritybx;
	
	@FindBy(name="nominee_phone")
	private WebElement nomiphonebx;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitbt;
	
	//initialization
	public CreateClientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getClientid() {
		return clientid;
	}

	public WebElement getClientpw() {
		return clientpw;
	}

	public WebElement getNamebx() {
		return namebx;
	}

	public WebElement getFileupbx() {
		return fileupbx;
	}

	public WebElement getGenderbx() {
		return genderbx;
	}

	public WebElement getBirdatebx() {
		return birdatebx;
	}

	public WebElement getStatusbx() {
		return statusbx;
	}

	public WebElement getNidbx() {
		return nidbx;
	}

	public WebElement getPhonebx() {
		return phonebx;
	}

	public WebElement getAddressbx() {
		return addressbx;
	}

	public WebElement getPolicybx() {
		return policybx;
	}

	public WebElement getAgentidbx() {
		return agentidbx;
	}

	public WebElement getNomineebx() {
		return nomineebx;
	}

	public WebElement getNomineenamebx() {
		return nomineenamebx;
	}

	public WebElement getGenderbx1() {
		return genderbx1;
	}

	public WebElement getNomibirthbx() {
		return nomibirthbx;
	}

	public WebElement getNomineenidbx() {
		return nomineenidbx;
	}

	public WebElement getNomirelationbx() {
		return nomirelationbx;
	}

	public WebElement getPrioritybx() {
		return prioritybx;
	}

	public WebElement getNomiphonebx() {
		return nomiphonebx;
	}

	public WebElement getSubmitbt() {
		return submitbt;
	}
	//Business Libraries
	public void createClient(HashMap<String,String> map , WebDriver driver) {
	 for(Entry<String, String> s:map.entrySet()) 
	   {
			   driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		   }
	}

}
