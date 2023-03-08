package testNGBankingSystem;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.banking.generic.DropdownUtility;
import com.banking.generic.ExcelUtility;
import com.banking.generic.InteractionUtility;
import com.banking.generic.JavaUtility;
import com.banking.generic.PopupUtility;
import com.banking.generic.PropertyUtility;
import com.banking.generic.ReportUtility;
import com.banking.generic.SeleniumUtility;
import com.banking.generic.VerificationUtility;
import com.banking.generic.WaitUtility;

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

public class BaseClassDeclaration {
	
	public WebDriver driver;
	
	protected ExcelUtility excelUtility;
	public SeleniumUtility seleniumUtility;
	public JavaUtility javaUtility;
	protected PropertyUtility proprtyUtlts;
	protected VerificationUtility verificationUtility;
	protected PopupUtility popupUtility;
	protected WaitUtility waitUtility;
	protected DropdownUtility dropdownUtility;
	protected InteractionUtility interactionUtility;
	protected ReportUtility report;

	protected HomePage homePg;
	protected OpenAccountPage openaccPg;
	protected CommonPage commonPg;
	protected StaffLoginPage stafflgnPg;
	protected StaffPage staffPg;
	protected ApprovePendingAccountPage appPndAcPg;
	protected ViewActiveCustomerPage viewActCustPg;
	protected IBRegistrationPage ibRegPage;
	protected ApplyDebitCardPage applyDCPg;
	protected IBLoginPage iblgnPage;
	protected CustomerIBPage custIBPg;
	protected ChangePasswordPage changPwdPg;

	protected String browser;
	protected long timeOut;
	protected String url;
	protected String username;
	protected String password;
	protected String name_;
	protected String sheetName;
	protected int randomNumber;
	public ExtentTest test;
}
