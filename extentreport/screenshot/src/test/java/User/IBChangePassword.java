package User;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ApplyDebitCardPage;
import objectRepository.ApprovePendingAccountPage;
import objectRepository.CommonPage;
import objectRepository.CustomerIBPage;
import objectRepository.IBLoginPage;
import objectRepository.IBRegistrationPage;
import objectRepository.OpenAccountPage;
import objectRepository.StaffLoginPage;
import objectRepository.StaffPage;
import objectRepository.ViewActiveCustomerPage;

public class IBChangePassword {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		PropertyUtility proprtyUtlts = new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		ExcelUtility excelUtility = new ExcelUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		PopupUtility popupUtility = new PopupUtility();
		JavaUtility javaUtility  = new JavaUtility();
		SeleniumUtility seleniumUtility = new SeleniumUtility();
		VerificationUtility verificationUtility = new VerificationUtility();
		       //common data
				String browser = proprtyUtlts.getPropertyData(PropertyKey.BROWSER);
				long timeOut = Long.parseLong(proprtyUtlts.getPropertyData(PropertyKey.TIMEOUT));
				String url = proprtyUtlts.getPropertyData(PropertyKey.URL);
				String username = proprtyUtlts.getPropertyData(PropertyKey.USERNAME);
				String password = proprtyUtlts.getPropertyData(PropertyKey.PASSWORD);
				//test data
				String sheetName = ExcelSheet.User.getSheetName();
				String exptestCaseName = "IBChangePasswordTest";
				Map<String, String> map = excelUtility.getData(sheetName, exptestCaseName);
				javaUtility.consolePrint(map);
		WebDriver driver = seleniumUtility.launchBrowser(javaUtility.decode(browser), "option");
		seleniumUtility.maximizeBrowser();
		seleniumUtility.launchApplication(javaUtility.decode(url));
		String name_ = map.get("name")+"_"+ javaUtility.getRandomNumber(100);                   //new Random().nextInt(100);
		
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
		
	
		
	/*	InteractionUtility interactionUtility = new InteractionUtility(driver);
		WebElement Ib = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		interactionUtility.mouseHover(Ib);
		driver.findElement(By.xpath("//li[text()='Login ']")).click();
		driver.findElement(By.name("customer_id")).sendKeys("1011695");
		driver.findElement(By.name("password")).sendKeys(map.get("password"));
		driver.findElement(By.name("login-btn")).click();
		driver.findElement(By.xpath("//li[text()='Change Password']")).click();
		driver.findElement(By.name("oldpass")).sendKeys(map.get("password"));
		driver.findElement(By.name("cnfrm")).sendKeys(map.get("confirmpassword"));
		driver.findElement(By.name("newpass")).sendKeys(map.get("newpassword"));
		driver.findElement(By.name("change_pass")).click();
		popupUtility.acceptAlert(driver);
		driver.findElement(By.name("logout_btn")).click();
		driver.findElement(By.name("customer_id")).sendKeys("1011695");
		driver.findElement(By.name("password")).sendKeys(map.get("newpassword"));
		driver.findElement(By.name("login-btn")).click();
		String acwlc =  driver.findElement(By.xpath("//div[@class='welcome']/label")).getText();
		String exwlc = "Welcome dipti_66";
		verificationUtility.exactVerify(acwlc, exwlc, "element", "welcome element");*/
	}

}
