package testNGBankingSystem;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.banking.generic.DropdownUtility;
import com.banking.generic.ExcelSheet;
import com.banking.generic.ExcelUtility;
import com.banking.generic.FrameworkConstants;
import com.banking.generic.InteractionUtility;
import com.banking.generic.JavaUtility;
import com.banking.generic.PopupUtility;
import com.banking.generic.PropertyKey;
import com.banking.generic.PropertyUtility;
import com.banking.generic.SeleniumUtility;
import com.banking.generic.VerificationUtility;
import com.banking.generic.WaitUtility;

import listener.ExtentReportsListener;
import objectRepository.ApplyDebitCardPage;
import objectRepository.ApprovePendingAccountPage;
import objectRepository.ChangePasswordPage;
import objectRepository.CommonPage;
import objectRepository.CustomerIBPage;
import objectRepository.HomePage;
import objectRepository.IBLoginPage;
import objectRepository.IBRegistrationPage;
import objectRepository.OpenAccountPage;
import objectRepository.StaffLoginPage;
import objectRepository.StaffPage;
import objectRepository.ViewActiveCustomerPage;

public class BaseClass extends BaseClassDeclaration{
	
	
	@Parameters(value = "browser")
	@BeforeClass(alwaysRun = true)
	public void initialiationSetUp(@Optional String browser) throws IOException {
		report = ExtentReportsListener.sreport;
		javaUtility = new JavaUtility();
		seleniumUtility = new SeleniumUtility();
		verificationUtility = new VerificationUtility();
		dropdownUtility = new DropdownUtility();
		popupUtility = new PopupUtility();
		proprtyUtlts = new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		excelUtility = new ExcelUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		this.browser = browser;
		if (browser == null || browser.isBlank() || browser.isEmpty() || browser.equals(""))

			 this.browser =  proprtyUtlts.getPropertyData(PropertyKey.BROWSER);
		driver = seleniumUtility.launchBrowser(this.browser);
		// common data
		browser = proprtyUtlts.getPropertyData(PropertyKey.BROWSER);
		timeOut = Long.parseLong(proprtyUtlts.getPropertyData(PropertyKey.TIMEOUT));
		url = proprtyUtlts.getPropertyData(PropertyKey.URL);
		username = proprtyUtlts.getPropertyData(PropertyKey.USERNAME);
		password = proprtyUtlts.getPropertyData(PropertyKey.PASSWORD);
		randomNumber = javaUtility.getRandomNumber(1000);
	}

	@BeforeMethod(alwaysRun = true)
	public void methodSetup() {
		sheetName = ExcelSheet.User.getSheetName();

//		if (browser == null) {
//			driver = seleniumUtility.launchBrowser("chrome");
//		} else {
//			driver = seleniumUtility.launchBrowser(browser);
//		}

		seleniumUtility.maximizeBrowser();
		url = proprtyUtlts.getPropertyData(PropertyKey.URL);
		seleniumUtility.launchApplication(javaUtility.decode(url));
		waitUtility = new WaitUtility(driver, timeOut);
		interactionUtility = new InteractionUtility(driver);
		openaccPg = new OpenAccountPage(driver);
		commonPg = new CommonPage(driver);
		homePg = new HomePage(driver);
		stafflgnPg = new StaffLoginPage(driver);
		staffPg = new StaffPage(driver);
		appPndAcPg = new ApprovePendingAccountPage(driver);
		viewActCustPg = new ViewActiveCustomerPage(driver);
		ibRegPage = new IBRegistrationPage(driver);
		applyDCPg = new ApplyDebitCardPage(driver);
		iblgnPage = new IBLoginPage(driver);
		custIBPg = new CustomerIBPage(driver);
		changPwdPg = new ChangePasswordPage(driver);
		waitUtility.waitForElementLoad(driver, timeOut);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		seleniumUtility.closeBrowser();
	}

	@AfterClass(alwaysRun = true)
	public void initiallizationTearDown() throws IOException {
		excelUtility.close();
	}
}
