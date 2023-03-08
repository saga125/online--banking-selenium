package User;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccount {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("dipti");
		WebElement gender = driver.findElement(By.name("gender"));
		Select s1 = new Select(gender);
		s1.selectByValue("Female");
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("9876546780");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dipti@gmail.com");
		driver.findElement(By.xpath("//input[@name='landline']")).sendKeys("123455");
		driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("dob")).sendKeys("02031994");
		driver.findElement(By.xpath("//input[@name='pan_no']")).sendKeys("WERT3456");
		driver.findElement(By.xpath("//input[@name='citizenship']")).sendKeys("ghhlu");
		driver.findElement(By.xpath("//input[@name='homeaddrs']")).sendKeys("btm, bangalore");
		driver.findElement(By.xpath("//input[@name='officeaddrs']")).sendKeys("btm, bangalore");
		WebElement state = driver.findElement(By.name("state"));
		Select s2 = new Select(state);
		s2.selectByValue("Hawaii");
		WebElement city = driver.findElement(By.name("city"));
		Select s3 = new Select(city);
		s3.selectByValue("Miami");
		driver.findElement(By.xpath("//input[@name='pin']")).sendKeys("560045");
		driver.findElement(By.xpath("//input[@name='arealoc']")).sendKeys("micus");
		driver.findElement(By.xpath("//input[@name='nominee_name']")).sendKeys("tina");
		driver.findElement(By.xpath("//input[@name='nominee_ac_no']")).sendKeys("1009374656470");
		WebElement at = driver.findElement(By.name("acctype"));
		Select s4 = new Select(at);
		s4.selectByValue("Saving");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		WebDriverWait wait =new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a= driver.switchTo().alert();
		String tx = a.getText();
		String applNum = tx.replaceAll("[^0-9]", "");
		a.accept();
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.className("customer_id")).sendKeys("210001");
		driver.findElement(By.className("password")).sendKeys("password");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@value='Approve Pending Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Application number']")).sendKeys(applNum);
		driver.findElement(By.xpath("//input[@name='search_application']")).click();
		driver.findElement(By.xpath("//input[@name='approve_cust']")).click();
		Thread.sleep(3000);
		Alert a1= driver.switchTo().alert();
		String tx1 = a1.getText();
		String accNo = tx1.replaceAll("[^0-9]", "");
		a1.accept();
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='View Active Customer']")).click();
		List<WebElement> acnolist = driver.findElements(By.xpath("//tr/td[4]"));
		for (WebElement ele: acnolist) {
			String text = ele.getText();
			if (text.equals(accNo)) {
				System.out.println("customer account is present in active customer list");
			}
		}
	}

}
