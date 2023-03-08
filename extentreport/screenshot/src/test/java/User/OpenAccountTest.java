package User;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.banking.generic.DropdownUtility;
import com.banking.generic.ExcelSheet;
import com.banking.generic.ExcelUtility;
import com.banking.generic.FrameworkConstants;
import com.banking.generic.JavaUtility;
import com.banking.generic.PopupUtility;
import com.banking.generic.PropertyKey;
import com.banking.generic.PropertyUtility;
import com.banking.generic.SeleniumUtility;
import com.banking.generic.VerificationUtility;
import com.banking.generic.WaitUtility;

import objectRepository.ApprovePendingAccountPage;
import objectRepository.CommonPage;
import objectRepository.CreateAccAttr;
import objectRepository.HomePage;
import objectRepository.OpenAccountPage;
import objectRepository.StaffButtons;
import objectRepository.StaffLoginPage;
import objectRepository.StaffPage;
import objectRepository.TabNames;
import objectRepository.ViewActiveCustomerPage;

public class OpenAccountTest {

	public static void main(String[] args) throws IOException {
		
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
		String exptestCaseName = "OpenAccountTest";
		Map<String, String> map = excelUtility.getData(sheetName, exptestCaseName);
		javaUtility.consolePrint(map);
		
		String name_ = map.get("name")+"_"+ javaUtility.getRandomNumber(100);                   //new Random().nextInt(100);
		WebDriver driver = seleniumUtility.launchBrowser(javaUtility.decode(browser), "option");
		
		WaitUtility waitUtility = new WaitUtility(driver, 10);
		OpenAccountPage openaccPg = new OpenAccountPage(driver);
		CommonPage commonPg = new CommonPage(driver);
		StaffLoginPage stafflgnPg = new StaffLoginPage(driver);
		StaffPage staffPg = new StaffPage(driver);
		ApprovePendingAccountPage appPndAcPg = new ApprovePendingAccountPage(driver);
		ViewActiveCustomerPage viewActCustPg = new ViewActiveCustomerPage(driver);
		
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
		
		String tx1 = popupUtility.getDataFromAlert(driver);
		String accNo = tx1.replaceAll("[^0-9]", "");
		popupUtility.acceptAlert(driver);
		
		commonPg.logoutAction();
	
		stafflgnPg.lgnAction(javaUtility.decode(username), javaUtility.decode(password));
		
		staffPg.clickButton(StaffButtons.VIEWACTIVECUSTOMER);
		
		viewActCustPg.accNoVerification(verificationUtility, accNo);
		
		commonPg.logoutAction();
		
		seleniumUtility.closeBrowser();
		
		
	//	driver.findElement(By.xpath("//li[text()='Open Account']")).click();
	/*	driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		
		WebElement gender = driver.findElement(By.name("gender"));
		dropdownUtility.handleDropDown(gender, map.get("gender"));
		
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(map.get("mobile"));
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(map.get("email"));
		driver.findElement(By.xpath("//input[@name='landline']")).sendKeys(map.get("landline"));
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys(map.get("DOB"));
		driver.findElement(By.xpath("//input[@name='pan_no']")).sendKeys(map.get("PAN"));
		driver.findElement(By.xpath("//input[@name='citizenship']")).sendKeys(map.get("citizenship"));
		driver.findElement(By.xpath("//input[@name='homeaddrs']")).sendKeys(map.get("homeaddress"));
		driver.findElement(By.xpath("//input[@name='officeaddrs']")).sendKeys(map.get("officeaddress"));
		
		WebElement state = driver.findElement(By.xpath("//select[@name='state']"));
		dropdownUtility.handleDropDown(state, map.get("state"));
		
		WebElement city = driver.findElement(By.name("city"));
		dropdownUtility.handleDropDown(city, map.get("city"));
		
		driver.findElement(By.xpath("//input[@name='pin']")).sendKeys(map.get("pin"));
		driver.findElement(By.xpath("//input[@name='arealoc']")).sendKeys(map.get("area"));
		driver.findElement(By.xpath("//input[@name='nominee_name']")).sendKeys(map.get("nomineename"));
		driver.findElement(By.xpath("//input[@name='nominee_ac_no']")).sendKeys(map.get("nomineeacno"));
		
		WebElement at = driver.findElement(By.name("acctype"));
		dropdownUtility.handleDropDown(at, map.get("acctype"));
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		
		waitUtility.waitUntilPresenceOfAlert();
		
		String tx = popupUtility.getDataToAlert(driver);
		String applNum = tx.replaceAll("[^0-9]", "");
		popupUtility.acceptAlert(driver);
		
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.className("customer_id")).sendKeys(javaUtility.decode(username));
		driver.findElement(By.className("password")).sendKeys(javaUtility.decode(password));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@value='Approve Pending Account']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Application number']")).sendKeys(applNum);
		driver.findElement(By.xpath("//input[@name='search_application']")).click();
		driver.findElement(By.xpath("//input[@name='approve_cust']")).click();
		
		String tx1 = popupUtility.getDataToAlert(driver);
		String accNo = tx1.replaceAll("[^0-9]", "");
		popupUtility.acceptAlert(driver);
		
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.xpath("//input[@value='View Active Customer']")).click();
		List<WebElement> acnolist = driver.findElements(By.xpath("//tr/td[4]"));
		for (WebElement ele: acnolist) {
			String text = ele.getText();
			  if (text.equalsIgnoreCase(accNo)) {
				verificationUtility.exactVerify(text, accNo, "TC", "Open Account");
			}
		}
		
		driver.findElement(By.name("logout_btn")).click();
		seleniumUtility.closeBrowser();*/
	}

}
