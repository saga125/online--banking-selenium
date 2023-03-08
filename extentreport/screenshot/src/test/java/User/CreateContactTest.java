package User;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import com.banking.generic.PropertyKey;
import com.banking.generic.PropertyUtility;
import com.banking.generic.SeleniumUtility;
import com.banking.generic.VerificationUtility;
import com.banking.generic.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest {

	public static void main(String[] args) throws IOException {
		SeleniumUtility seleniumUtility = new SeleniumUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
        WebElement Ib = driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']"));
        String path = seleniumUtility.getScreenShot(Ib,"MenuIcon", ".PNG");
        System.out.println(path);
	/*	PropertyUtility proprtyUtlts = new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		ExcelUtility excelUtility = new ExcelUtility(FrameworkConstants.TEST_EXCEL_FILE_PATH);
		JavaUtility javaUtility  = new JavaUtility();
	//	SeleniumUtility seleniumUtility = new SeleniumUtility();
		VerificationUtility verificationUtility = new VerificationUtility();
		
		//common data
		String browser = proprtyUtlts.getPropertyData(PropertyKey.BROWSER);
		long timeout = Long.parseLong(proprtyUtlts.getPropertyData(PropertyKey.TIMEOUT));
		String url = proprtyUtlts.getPropertyData(PropertyKey.URL);
		String username = proprtyUtlts.getPropertyData(PropertyKey.USERNAME);
		String password = proprtyUtlts.getPropertyData(PropertyKey.PASSWORD);
		
		 
		
		byte[] ar = username.getBytes();
		 for (byte b: ar) {
			 System.out.println(b);
		 }
		 
		 System.out.println("------------------");
		 byte[] br = Base64.getDecoder().decode(ar);
		 for (byte b: br) {
			 System.out.println(b);
		 }
		 
		 System.out.println(new String(br));
		 
		
		//test data
		String sheetName = ExcelSheet.CONTACTS.getSheetName();
		String exptestCaseName = "CreateContactTest";
		Map<String, String> map = excelUtility.getData(sheetName, exptestCaseName);
		System.out.println(map);
		
		String name = map.get("name")+"_"+new Random().nextInt(100);
		
		
		
		WebDriver driver = seleniumUtility.launchBrowser(browser);
		InteractionUtility interactionUtility = new InteractionUtility(driver);
		
		//pre-setting for the browser
		seleniumUtility.maximizeBrowser();
		waitUtility.waitForElementLoad(driver, timeout);
		//navigating the application
		seleniumUtility.launchApplication(url);
		//login to the app
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);  //data4
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);*/
	}

}
