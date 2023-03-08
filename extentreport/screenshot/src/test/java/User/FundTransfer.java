package User;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FundTransfer {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
        WebElement Ib = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
        a.moveToElement(Ib).perform();
        driver.findElement(By.xpath("//li[text()='Login ']")).click();
        driver.findElement(By.name("customer_id")).sendKeys("1011323");
        driver.findElement(By.name("password")).sendKeys("dipti12");
        driver.findElement(By.name("login-btn")).click();
        driver.findElement(By.xpath("//li[text()='Fund Transfer']"));
        driver.findElement(By.name("add_beneficiary")).click();
        driver.findElement(By.name("beneficiary_name")).sendKeys("dipti-78");
        driver.findElement(By.name("beneficiary_acno")).sendKeys("1011421011868");
        driver.findElement(By.name("Ifsc_code")).sendKeys("1011");
        WebElement acctype = driver.findElement(By.name("beneficiary_acc_type"));
        Select s = new Select(acctype);
        s.selectByValue("Saving");
        driver.findElement(By.name("add_beneficiary_btn")).click();
        
	}

}
