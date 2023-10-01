package TestNGtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.insu.Genericutils.BaseClass;
import com.insur.ObjectRespositary.AddPaymentButtonPage;
import com.insur.ObjectRespositary.AddPaymentPage;
import com.insur.ObjectRespositary.ClickOnClientStatusLinkPage;
import com.insur.ObjectRespositary.HomePage;

public class AddPaymentTest extends BaseClass{
	@Test
	public void createPaymentUsingPomTestng() throws Throwable {
		HomePage h=new HomePage(driver);
		h.clickOnClient();
		
		JavascriptExecutor j=(JavascriptExecutor)driver;
		 for(int i=0;i<8;i++) {
		    	j.executeScript("window.scrollBy(0,10000)");
		    	
		 }
		//ENTER THE CLIENT STATUS LINK
		 ClickOnClientStatusLinkPage c=new ClickOnClientStatusLinkPage(driver);
		 c.clickOnClientStatus();
		 
		// driver.findElement(By.xpath("(//a[.='Client Status'])[351]")).click();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		 for(int x=0;x<4;x++) {
		    	js.executeScript("window.scrollBy(0,400)");
		    	}
		 
		 
		// driver.findElement(By.xpath("//a[.='Add Payment']")).click(); 
		 //CLICK ON THE PAYMENT LINK
		 AddPaymentButtonPage a=new AddPaymentButtonPage(driver);
		 a.clickOnPaymentLink();
		 
		//ENTER MANDATORY FIELDS 
		 AddPaymentPage a1=new AddPaymentPage(driver);
		 a1.createPayment(eLib.getMultipleDataFromExcel("payment", 0, 1,driver), driver);
		 
			 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//VALIDATION
		 
		 String str = driver.findElement(By.xpath("//div[@class='row']")).getText();
			
			if(str.contains("New Payment ADDED")){
				
			 
				System.out.println("Payment  is added suscessfully");
			}
			else {
				System.out.println("Payment  is not added suscessfully");
			}
	}

}
