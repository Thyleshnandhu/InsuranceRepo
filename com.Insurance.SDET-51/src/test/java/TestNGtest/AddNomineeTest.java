package TestNGtest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.insu.Genericutils.BaseClass;
import com.insur.ObjectRespositary.AddNomineeButtonPage;
import com.insur.ObjectRespositary.CreateNomineePage;
import com.insur.ObjectRespositary.HomePage;

public class AddNomineeTest extends BaseClass {
	@Test
        public void createNomineeUsingPomTestng() throws Throwable {
		//CLICK ON THE NOMINEE MODULE  
		HomePage h=new HomePage(driver);
		h.clickOnNominee();
        //CLICK ON THE NOMINEE BUTTON
		AddNomineeButtonPage a=new AddNomineeButtonPage(driver);
		a.clickOnNomineeButton();
		//ENTER THE MANDATORY FIELDS
		CreateNomineePage c=new CreateNomineePage(driver);
		c.nomineePage(eLib.getMultipleDataFromExcel("Nominee", 0, 1, driver), driver);
		CreateNomineePage c1= new CreateNomineePage(driver);
		c1.enterSubmitBtn();
		String str=driver.findElement(By.xpath("//div[@class='row']")).getText();
		
		if(str.contains("New Nominee ADDED")) {
			System.out.println("New nominee is added Sucessfully");
			
		}
		else {
			System.out.println("New nominee is not added Successfully");
		}
		
		

}
}
