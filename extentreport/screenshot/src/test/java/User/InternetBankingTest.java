package User;

import java.io.IOException;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

import objectRepository.ApplyDCTxFlds;
import objectRepository.ApplyDebitCardPage;
import objectRepository.ApprovePendingAccountPage;
import objectRepository.CommonPage;
import objectRepository.CreateAccAttr;
import objectRepository.CustomerIBPage;
import objectRepository.HomePage;
import objectRepository.IBLoginPage;
import objectRepository.IBRegistrationPage;
import objectRepository.IBRegstrtnTxFlds;
import objectRepository.OpenAccountPage;
import objectRepository.StaffButtons;
import objectRepository.StaffLoginPage;
import objectRepository.StaffPage;
import objectRepository.TabNames;
import objectRepository.ViewActiveCustomerPage;


public class InternetBankingTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		PropertyUtility proprtyUtlts = new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		ExcelUtility excelUtility = new ExcelUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		JavaUtility javaUtility  = new JavaUtility();
		SeleniumUtility seleniumUtility = new SeleniumUtility();
		VerificationUtility verificationUtility = new VerificationUtility();
		DropdownUtility dropdownUtility = new DropdownUtility();
		PopupUtility popupUtility = new PopupUtility();
		
		//common data
		String browser = proprtyUtlts.getPropertyData(PropertyKey.BROWSER);
		long timeOut = Long.parseLong(proprtyUtlts.getPropertyData(PropertyKey.TIMEOUT));
		String url = proprtyUtlts.getPropertyData(PropertyKey.URL);
		String username = proprtyUtlts.getPropertyData(PropertyKey.USERNAME);
		String password = proprtyUtlts.getPropertyData(PropertyKey.PASSWORD);
		
		//test data
		String sheetName = ExcelSheet.User.getSheetName();
		String exptestCaseName = "InternetBankingTest";
		Map<String, String> map = excelUtility.getData(sheetName, exptestCaseName);
		javaUtility.consolePrint(map);
		
		String name_ = map.get("name")+"_"+ javaUtility.getRandomNumber(100);                   //new Random().nextInt(100);
		WebDriver driver = seleniumUtility.launchBrowser(javaUtility.decode(browser), "option");
		
		WaitUtility waitUtility = new WaitUtility(driver, 10);
		InteractionUtility interactionUtlty = new InteractionUtility(driver);
		OpenAccountPage openaccPg = new OpenAccountPage(driver);
		CommonPage commonPg = new CommonPage(driver);
		StaffLoginPage stafflgnPg = new StaffLoginPage(driver);
		StaffPage staffPg = new StaffPage(driver);
		ApprovePendingAccountPage appPndAcPg = new ApprovePendingAccountPage(driver);
		ViewActiveCustomerPage viewActCustPg = new ViewActiveCustomerPage(driver);
		ApplyDebitCardPage applyDCPg = new ApplyDebitCardPage(driver);
		IBRegistrationPage ibRegPage = new IBRegistrationPage(driver);
		IBLoginPage iblgnPage  = new IBLoginPage(driver);
		CustomerIBPage custIBPg = new CustomerIBPage(driver);
		
		//pre-setting for the browser
		seleniumUtility.maximizeBrowser();
		waitUtility.waitForElementLoad(driver, timeOut);
		//navigating the application
		seleniumUtility.launchApplication(javaUtility.decode(url));
		
		HomePage homePg = new HomePage(driver);
		homePg.openAccAction();
		openaccPg.sendValue(CreateAccAttr.NAME, name_);
		
		WebElement gnd = openaccPg.genderAction();
		dropdownUtility.handleDropDown(gnd, map.get("gender"));
		
		openaccPg.sendValue(CreateAccAttr.MOBILE, map.get("mobile"));
		openaccPg.sendValue(CreateAccAttr.EMAIL, map.get("email"));
		openaccPg.sendValue(CreateAccAttr.LANDLINE, map.get("landline"));
		
		openaccPg.dobAction().click();
		openaccPg.dobAction().sendKeys(map.get("DOB"));
		
		openaccPg.sendValue(CreateAccAttr.PANNO, map.get("PAN"));
		openaccPg.sendValue(CreateAccAttr.CITIZENSHIP, map.get("citizenship"));
		openaccPg.sendValue(CreateAccAttr.HOMEADDRESS, map.get("homeaddress"));
		openaccPg.sendValue(CreateAccAttr.OFFICEADDRESS, map.get("officeaddress"));
		
		WebElement state =  openaccPg.stateAction();
		dropdownUtility.handleDropDown(state, map.get("state"));
		
		WebElement city = openaccPg.cityAction();
		dropdownUtility.handleDropDown(city, map.get("city"));
		
		openaccPg.sendValue(CreateAccAttr.PIN, map.get("pin"));
		openaccPg.sendValue(CreateAccAttr.AREALOC, map.get("area"));
		openaccPg.sendValue(CreateAccAttr.NOMINEENAME, map.get("nomineename"));
		openaccPg.sendValue(CreateAccAttr.NOMINEEACCNO, map.get("nomineeacno"));
		
		WebElement accType = openaccPg.accTypeAction();
		dropdownUtility.handleDropDown(accType, map.get("acctype"));
		
		openaccPg.submitAction();
		openaccPg.confirmAction();
		
		waitUtility.waitUntilPresenceOfAlert();
		
		String tx = popupUtility.getDataFromAlert(driver);
		String applNum = tx.replaceAll("[^0-9]", "");
		popupUtility.acceptAlert(driver);
		
		commonPg.clickTab(TabNames.STAFFLOGIN);
		stafflgnPg.lgnAction(javaUtility.decode(username), javaUtility.decode(password));
		staffPg.clickButton(StaffButtons.APPROVEPENDINGACCOUNT);
		appPndAcPg.approvePendingAccountAction(applNum);
		
		waitUtility.waitUntilPresenceOfAlert();
		
		waitUtility.pause(5000);
		
		String tx1 = popupUtility.getDataFromAlert(driver);
		String accNo = tx1.replaceAll("[^0-9]", "");
		popupUtility.acceptAlert(driver);
		
		commonPg.logoutAction();
	
		stafflgnPg.lgnAction(javaUtility.decode(username), javaUtility.decode(password));
		
		staffPg.clickButton(StaffButtons.VIEWACTIVECUSTOMER);
		
		viewActCustPg.accNoVerification(verificationUtility, accNo);
		
		commonPg.logoutAction();
		commonPg.clickTab(TabNames.HOME);
		
		homePg.applDebitCard();
		applyDCPg.sendValues(ApplyDCTxFlds.HOLDER_NAME, name_);
		applyDCPg.clickAction(ApplyDCTxFlds.DOB);
		applyDCPg.sendValues(ApplyDCTxFlds.DOB, map.get("DOB"));
		applyDCPg.sendValues(ApplyDCTxFlds.PAN, map.get("PAN"));
		applyDCPg.sendValues(ApplyDCTxFlds.MOB, map.get("mobile"));
		applyDCPg.sendValues(ApplyDCTxFlds.ACC_NO, accNo);
		applyDCPg.clickAction(ApplyDCTxFlds.SUBMIT);
		
		String tx3 = popupUtility.getDataFromAlert(driver);
		String str1 = tx3.replaceAll("[^0-9]", " ");
		String str2 = str1.replaceAll(" +", " ");
		String str3 = str2.trim();
		String [] na = str3.split(" ");
		String dcn = na[0];
		String dcp = na[1];
		popupUtility.acceptAlert(driver);
		
		commonPg.clickTab(TabNames.HOME);
		homePg.IbAction(interactionUtlty);
		homePg.regstrAction();
		ibRegPage.sendValues(IBRegstrtnTxFlds.HOLDER_NAME, name_);
		ibRegPage.sendValues(IBRegstrtnTxFlds.ACCNUM, accNo);
		ibRegPage.sendValues(IBRegstrtnTxFlds.DBTCARD, dcn);
		ibRegPage.sendValues(IBRegstrtnTxFlds.DBTPIN, dcp);
		ibRegPage.sendValues(IBRegstrtnTxFlds.MOBILE, map.get("mobile"));
		ibRegPage.sendValues(IBRegstrtnTxFlds.PAN_NO, map.get("PAN"));
		ibRegPage.clickAction(IBRegstrtnTxFlds.DOB);
		ibRegPage.sendValues(IBRegstrtnTxFlds.DOB, map.get("DOB"));
		ibRegPage.sendValues(IBRegstrtnTxFlds.LAST_TRANS, map.get("lasttransaction"));
		ibRegPage.sendValues(IBRegstrtnTxFlds.PASSWORD, map.get("password"));
		ibRegPage.sendValues(IBRegstrtnTxFlds.CNFRM_PASSWORD, map.get("confirmpassword"));
		ibRegPage.clickAction(IBRegstrtnTxFlds.SUBMIT);
		
		String tx4 = popupUtility.getDataFromAlert(driver);
		String custID = tx4.replaceAll("[^0-9]", "");
		popupUtility.acceptAlert(driver);
		
		commonPg.clickTab(TabNames.HOME);
		homePg.IbAction(interactionUtlty);
		
		homePg.lgnAction();
		
		iblgnPage.ibLoginAction(custID, map.get("password"));
		
		String custWelcomeMsg = custIBPg.welomeMsgAction();
		verificationUtility.exactVerify(custWelcomeMsg, "Welcome "+name_ , "page", "Customer profile");
		seleniumUtility.closeBrowser();
		
		
	/*	driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
		driver.findElement(By.name("holder_name")).sendKeys("dipti_46");
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys(map.get("DOB"));
		driver.findElement(By.name("pan")).sendKeys(map.get("PAN"));
		driver.findElement(By.name("mob")).sendKeys(map.get("mobile"));
		driver.findElement(By.name("acc_no")).sendKeys("1011311011457");
		driver.findElement(By.name("dbt_crd_submit")).click();
		
		String tx3 = popupUtility.getDataToAlert(driver);
		String str1 = tx3.replaceAll("[^0-9]", " ");
		String str2 = str1.replaceAll(" +", " ");
		String str3 = str2.trim();
		String [] na = str3.split(" ");
		String dcn = na[0];
		String dcp = na[1];
		popupUtility.acceptAlert(driver);
		
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		
		WebElement Ib = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		interactionUtility.mouseHover(Ib);

		driver.findElement(By.xpath("//li[text()='Register']")).click();
		driver.findElement(By.name("holder_name")).sendKeys(name_);
		driver.findElement(By.name("accnum")).sendKeys("1011311011457");
		driver.findElement(By.name("dbtcard")).sendKeys(dcn);
		driver.findElement(By.name("dbtpin")).sendKeys(dcp);
		driver.findElement(By.name("mobile")).sendKeys(map.get("mobile"));
		driver.findElement(By.name("pan_no")).sendKeys(map.get("PAN"));
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys(map.get("DOB"));
		driver.findElement(By.name("last_trans")).sendKeys(map.get("lasttransaction"));
		driver.findElement(By.name("password")).sendKeys(map.get("password"));
		driver.findElement(By.name("cnfrm_password")).sendKeys(map.get("confirmpassword"));
		driver.findElement(By.name("submit")).click();
		
		String tx4 = popupUtility.getDataToAlert(driver);
		String custID = tx4.replaceAll("[^0-9]", "");
		popupUtility.acceptAlert(driver);
		
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		WebElement Ib1 = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		interactionUtility.mouseHover(Ib1);
		
		driver.findElement(By.xpath("//li[text()='Login ']")).click();
		driver.findElement(By.name("customer_id")).sendKeys(custID);
		driver.findElement(By.name("password")).sendKeys(map.get("password"));
		driver.findElement(By.name("login-btn")).click();  */
	}

}
