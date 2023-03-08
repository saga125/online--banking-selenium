package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.banking.generic.ExcelUtility;
import com.banking.generic.FrameworkConstants;
import com.banking.generic.JavaUtility;

public class SelectDateInOrgCalenderTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUtility javaUtility = new JavaUtility();
		ExcelUtility excelUtility = new ExcelUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		Map<String, String> testData = excelUtility.getData(ExcelSheet.User, null)
	}

}
