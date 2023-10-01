package TestNG;

import org.testng.annotations.Test;

public class DBExcelTest {
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "dataFromExcel")
	public void getData(String name, String  price, String size) {
		System.out.println(name+"  "+price+"  "+size);
	}

}
