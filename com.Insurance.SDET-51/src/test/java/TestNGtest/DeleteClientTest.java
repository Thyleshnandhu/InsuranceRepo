package TestNGtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.insu.Genericutils.BaseClass;
import com.insur.ObjectRespositary.DeleteClientsPage;
import com.insur.ObjectRespositary.EditClientPage;
import com.insur.ObjectRespositary.HomePage;

public class DeleteClientTest extends BaseClass {
	@Test
	public void deleteClientUsingPomTestng() {
		HomePage h=new HomePage(driver);
		h.clickOnClient();

		JavascriptExecutor j=(JavascriptExecutor)driver;
		 for(int i=0;i<8;i++) {
		    	j.executeScript("window.scrollBy(0,10000)");
		    	
		 }
		 EditClientPage d=new EditClientPage(driver);
		 d.clickOnEdit();
		 
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 for(int x=0;x<4;x++) {
		    	js.executeScript("window.scrollBy(0,400)");
	}
		 DeleteClientsPage q=new  DeleteClientsPage(driver);
		 q.clickOnTheDeleteLink();
		 
		 String str = driver.findElement(By.xpath("//div[@class='row']")).getText();
			
			if(str.contains("Client deleted successfully")){
				
			 
				System.out.println("Client  is deleted suscessfully");
			}
			else {
				System.out.println("Client  is not deleted suscessfully");
			}
		
	}

}
