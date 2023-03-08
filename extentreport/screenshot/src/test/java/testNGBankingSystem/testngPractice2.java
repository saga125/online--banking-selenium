package testNGBankingSystem;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.generic.ExcelUtility;
import com.banking.generic.FrameworkConstants;

public class testngPractice2 {
	
	@Test(dataProvider = "data")
	public void test1(String username, String password) {
		System.out.println(username+" "+password);
		System.out.println("hii");
	}
	
	@DataProvider
	public String[][] data() throws EncryptedDocumentException, IOException {
		ExcelUtility excel = new ExcelUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		return excel.getData("dataprovider");
	}
	
/*	@DataProvider(name="abc")
	public String[] data() {
		String[] arr = new String[4];
		arr[0] = "Bangalore";
		arr[1] = "Mysore";
		arr[2] = "Chennai";
		arr[3] = "Delhi";
		
		return arr;
	}*/
}
