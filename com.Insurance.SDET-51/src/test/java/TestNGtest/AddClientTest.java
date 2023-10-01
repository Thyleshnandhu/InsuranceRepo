package TestNGtest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.insu.Genericutils.BaseClass;
import com.insur.ObjectRespositary.AddClientButtonPage;
import com.insur.ObjectRespositary.CreateClientPage;
import com.insur.ObjectRespositary.HomePage;

public class AddClientTest extends BaseClass {
	@Test
	public void createClientUsingPomTestng() throws Throwable {
		
		HomePage h=new HomePage(driver);
		h.clickOnClient();
		
		AddClientButtonPage a=new AddClientButtonPage(driver);
		a.clickOnClientButton();
		
		 //ENTER THE MANDATORY FIELDS
		CreateClientPage c=new CreateClientPage(driver);
		c.createClient(eLib.getMultipleDataFromExcel("Client", 0, 1,driver), driver);
		
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		 String str = driver.findElement(By.xpath("//div[@class='row']")).getText();
			
			if(str.contains("New Client ADDED")) {
				System.out.println("client is added suscessfully");
			}
			else {
				System.out.println("client is not added suscessfully");
			}
	}

}
