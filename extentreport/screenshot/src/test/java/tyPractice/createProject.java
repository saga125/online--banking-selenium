package tyPractice;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createProject {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']"));
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("selenium_08");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("sagarika1");
		driver.findElement(By.xpath("//input[@value = 'Add Project']")).click();
		List<WebElement> projectNames = driver.findElements(By.xpath("//tr//td[2]"));
		for (WebElement pName : projectNames) {
			if (pName.equals("selenium_08")) {
				System.out.println("project name is displayed");
			}
		}
		List<WebElement> projectManagers = driver.findElements(By.xpath("//tr/td[4]"));
		for (WebElement pManager : projectManagers) {
			if (pManager.equals("sagarika1")) {
				System.out.println("project manager is displayed");
				break;
			}
		}
	}

}
