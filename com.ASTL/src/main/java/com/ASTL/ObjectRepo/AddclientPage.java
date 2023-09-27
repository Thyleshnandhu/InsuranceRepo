package com.ASTL.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddclientPage 
{
	@FindBy(name="client_password")
	private WebElement Clientpassword;
	
	@FindBy(name="name")
	private WebElement Cilentname;
	
	@FindBy(name="fileToUpload")
	private WebElement Chooseimg;
	
	@FindBy(name="sex")
	private WebElement Clientgender;
	
	@FindBy(name="birth_date")
	private WebElement ClientDOB;
	
	@FindBy(name="maritial_status")
	private WebElement CLientmaritialstatus;
	
	@FindBy(name="nid")
	private WebElement ClientNationalID;
	
	@FindBy(name="phone")
	private WebElement ClientContact;
	
	@FindBy(name="address")
	private WebElement ClientAddress;
	
	@FindBy(name="policy_id")
	private WebElement Policyid;
	
	@FindBy(name="nominee_name")
	private WebElement NomineeName;
	
	@FindBy(name="nominee_sex")
	private WebElement NomineeGender;
	
	@FindBy(name="nominee_birth_date")
	private WebElement NomineeDOB;
	
	@FindBy(name="nominee_nid")
	private WebElement NomineeNID;
	
	@FindBy(name="nominee_relationship")
	private WebElement NomineeRelation;
	
	@FindBy(name="priority")
	private WebElement NomineePriority;
	
	@FindBy(name="nominee_phone")
	private WebElement NomineeContact;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement ClickSubmit;
	
	
	//Initialization
	public AddclientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getClientpassword() {
		return Clientpassword;
	}


	public WebElement getCilentname() {
		return Cilentname;
	}


	public WebElement getChooseimg() {
		return Chooseimg;
	}


	public WebElement getClientgender() {
		return Clientgender;
	}


	public WebElement getClientDOB() {
		return ClientDOB;
	}


	public WebElement getCLientmaritialstatus() {
		return CLientmaritialstatus;
	}


	public WebElement getClientNationalID() {
		return ClientNationalID;
	}


	public WebElement getClientContact() {
		return ClientContact;
	}


	public WebElement getClientAddress() {
		return ClientAddress;
	}


	public WebElement getPolicyid() {
		return Policyid;
	}


	public WebElement getNomineeName() {
		return NomineeName;
	}


	public WebElement getNomineeGender() {
		return NomineeGender;
	}


	public WebElement getNomineeDOB() {
		return NomineeDOB;
	}


	public WebElement getNomineeNID() {
		return NomineeNID;
	}


	public WebElement getNomineeRelation() {
		return NomineeRelation;
	}


	public WebElement getNomineePriority() {
		return NomineePriority;
	}


	public WebElement getNomineeContact() {
		return NomineeContact;
	}


	public WebElement getClickSubmit() {
		return ClickSubmit;
	}
	
	//Business library
	public void getDataForClient(HashMap<String, String>map, WebDriver driver)
	{
		for(Entry<String, String> s:map.entrySet())
		{
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
	}
	
	public void clickOnsubmitButton()
	{
		ClickSubmit.click();
	}

}
