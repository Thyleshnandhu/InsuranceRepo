package com.ASTL.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//declaration
	@FindBy(name="key")
	private WebElement keybx;
	
	@FindBy(xpath="//input[@class='searchBtn']")
	private WebElement searchbtn;
	
	@FindBy(xpath="//div[@class='main-box mb-red']")
	private WebElement totalclientimage;
	
	@FindBy(xpath="//div[@class='main-box mb-dull']")
	private WebElement paymentrecordsimg;
	
    @FindBy(xpath="//div[@class='main-box mb-pink']")
    private WebElement totalclientimg;
    
    @FindBy(xpath="//a[@class='btn btn-danger']")
    private WebElement logoutbx;
    
    @FindBy(linkText="CLIENTS")
    private WebElement clientmod;
    
    @FindBy(linkText="AGENTS")
    private WebElement agentmod;
    
    @FindBy(linkText="POLICY")
    private WebElement policymod;
    
    @FindBy(linkText="NOMINEE")
    private WebElement nomineemod;
    
    @FindBy(linkText="PAYMENTS")
    private WebElement paymentmod;
    
    
    
   

	

	//initialization
    public HomePage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    //utilization

	public WebElement getKeybx() {
		return keybx;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getTotalclientimage() {
		return totalclientimage;
	}

	public WebElement getPaymentrecordsimg() {
		return paymentrecordsimg;
	}

	public WebElement getTotalclientimg() {
		return totalclientimg;
	}

	public WebElement getLogoutbx() {
		return logoutbx;
	}

	public WebElement getClientmod() {
		return clientmod;
	}

	public WebElement getAgentmod() {
		return agentmod;
	}

	public WebElement getPolicymod() {
		return policymod;
	}

	public WebElement getNomineemod() {
		return nomineemod;
	}

	public WebElement getPaymentmod() {
		return paymentmod;
	}
	
	
	//Business Libraries
    
   public void clickOnNominee() {
	   nomineemod.click();
   }
   public void clickOnClient() {
	   clientmod.click();
   }
   public void clickOnLogout() {
	   logoutbx.click();
   }
   public void clickOnPayment() {
	   paymentmod.click(); 
   }
  
    }
    
    
