package User;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginInternetBanking {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
		driver.findElement(By.name("holder_name")).sendKeys("dipti");
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys("02031994");
		driver.findElement(By.name("pan")).sendKeys("WERT3456");
		driver.findElement(By.name("mob")).sendKeys("9876546780");
		driver.findElement(By.name("acc_no")).sendKeys("1011421011951");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Alert a3= driver.switchTo().alert();
		String tx3 = a3.getText();
		String str1 = tx3.replaceAll("[^0-9]", " ");
		String str2 = str1.replaceAll(" +", " ");
		String str3 = str2.trim();
		String [] na = str3.split(" ");
		String dcn = na[0];
		String dcp = na[1];
		a3.accept();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		WebElement Ib = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		Actions a = new Actions(driver);
		a.moveToElement(Ib).perform();
		driver.findElement(By.xpath("//li[text()='Register']")).click();
		driver.findElement(By.name("holder_name")).sendKeys("dipti");
		driver.findElement(By.name("accnum")).sendKeys("1011421011951");
		driver.findElement(By.name("dbtcard")).sendKeys(dcn);
		driver.findElement(By.name("dbtpin")).sendKeys(dcp);
		driver.findElement(By.name("mobile")).sendKeys("9876546780");
		driver.findElement(By.name("pan_no")).sendKeys("WERT3456");
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys("02031994");
		driver.findElement(By.name("last_trans")).sendKeys("0");
		driver.findElement(By.name("password")).sendKeys("dipti");
		driver.findElement(By.name("cnfrm_password")).sendKeys("dipti");
		driver.findElement(By.name("submit")).click();
		Alert a4= driver.switchTo().alert();
		String tx4 = a4.getText();
		String custID = tx4.replaceAll("[^0-9]", "");
		a4.accept();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		a.moveToElement(Ib).perform();
		driver.findElement(By.xpath("//li[text()='Login ']")).click();
	//	String custID = driver.findElement(By.xpath("//td[text()='9678736637']/..//td[3]")).getText();
		driver.findElement(By.name("customer_id")).sendKeys(custID);
		driver.findElement(By.name("password")).sendKeys("dipti");
		driver.findElement(By.name("login-btn")).click();
}
}
