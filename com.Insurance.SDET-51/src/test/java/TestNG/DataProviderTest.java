package TestNG;




import org.testng.annotations.DataProvider;

import com.insu.Genericutils.ExcelUtility;



public class DataProviderTest {
   
  @DataProvider
   public Object[][] mobile(){
	   Object[][] obj=new Object[2][2]; 
	   obj[0][0]="Redmi";
	   obj[0][1]=5000;
	 
	   
	   obj[1][0]="samsung";
	   obj[1][1]=9000;
	  
	   
	   return obj;
	   
   }
   @DataProvider
   public Object[][] tv(){
	   Object[][] obj=new Object[3][3];
	   obj[0][0]="LG";
	   obj[0][1]=5000;
	   obj[0][2]="45 inch";
	   
	   obj[1][0]="redmi";
	   obj[1][1]=9000;
	   obj[1][2]="95 inch";
	   
	   obj[2][0]="redmi";
	   obj[2][1]=9000;
	   obj[2][2]="95 inch";
	   
	   return obj;
   }
	@DataProvider
   public Object[][] dataFromExcel() throws Throwable{
	  ExcelUtility eLib= new ExcelUtility();
	  Object[][] value = eLib.getMultipleSetOfDataFromExcel("DP");
	  return value;
		
	 }
  }
