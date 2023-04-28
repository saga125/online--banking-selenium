package com.banking.generic;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.banking.enumFiles.ExcelSheet;
import com.banking.enumFiles.PropertyKey;

public class SelectDateInOrgCalenderTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
/*		JavaUtility javaUtility =  new JavaUtility();
		ExcelUtility excelUtility = new ExcelUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		Map<String, String> testData = excelUtility.getData(ExcelSheet.User.getSheetName(), "OpenAccountTest");
		javaUtility.consolePrint(testData);
		int reqMonthNum = javaUtility.getMonthNumber(testData.get("reqMonth"), "MMMM");
		int reqYearNum = javaUtility.parseNumber(testData.get("reqYear"));
		PropertyUtility propertyUtility = new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		JavaUtility javaUtility1 = new JavaUtility();
		SeleniumUtility seleniumUtility = new SeleniumUtility();
		
		//common data
		String browser = propertyUtility.getPropertyData(PropertyKey.BROWSER);
		long timeout = Long.parseLong(propertyUtility.getPropertyData(PropertyKey.TIMEOUT));
		String url = propertyUtility.getPropertyData(PropertyKey.URL);
		String username = propertyUtility.getPropertyData(PropertyKey.USERNAME);
		String password = propertyUtility.getPropertyData(PropertyKey.PASSWORD);
		WebDriver driver = seleniumUtility.launchBrowser(browser, "");
		WaitUtility waitUtility = new WaitUtility(driver, timeout);
		//pre-setting for the browser
		seleniumUtility.maximizeBrowser();
		waitUtility.waitForElementLoad(driver, timeout);
		//navigating the application
		seleniumUtility.launchApplication(url);  */
		
	}

}
