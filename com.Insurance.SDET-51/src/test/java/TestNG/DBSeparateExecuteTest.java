package TestNG;

import org.testng.annotations.Test;

public class DBSeparateExecuteTest {
	@Test(dataProviderClass  = DataProviderTest.class, dataProvider = "tv")
	public void getData(String name,int price) {
		System.out.println(name+"  "+price);
	}
	

}
