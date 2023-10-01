package com.insur.ObjectRespositary;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientDoPaymentPage {
	//declaration
		@FindBy(name="recipt_no")
		private WebElement receiptbx;
		
		@FindBy(name="client_id")
		private WebElement clientbx;
		
		@FindBy(name="month")
		private WebElement monthbx;
		
		@FindBy(name="amount")
		private WebElement amountbx;
		
		@FindBy(name="due")
		private WebElement duebx;
		
		@FindBy(name="fine")
		private WebElement finebx;
		
		@FindBy(name="agent_id")
		private WebElement agentbx;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement submitbtn;
		
		//initialization
		public ClientDoPaymentPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//utilization

		public WebElement getReceiptbx() {
			return receiptbx;
		}

		public WebElement getClientbx() {
			return clientbx;
		}

		public WebElement getMonthbx() {
			return monthbx;
		}

		public WebElement getAmountbx() {
			return amountbx;
		}

		public WebElement getDuebx() {
			return duebx;
		}

		public WebElement getFinebx() {
			return finebx;
		}

		public WebElement getAgentbx() {
			return agentbx;
		}

		public WebElement getSubmitbtn() {
			return submitbtn;
		}
		//Business Libraries
		public void createPayment(HashMap<String, String> map,WebDriver driver ) {
			for(Entry<String, String> s:map.entrySet()) 
			   {
					   driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
				   }
			
		}
		
}
