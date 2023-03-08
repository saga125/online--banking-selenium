package tyPractice;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddDataIntoProjectTableandVerifyInRMG {

	public static void main(String[] args) throws SQLException {
		// create instance and register to databasemanager
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection connection = null;

		try {
			// step2:-connect to jdbc
			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");// rmg
																														// database
																														// connection
			// step3:- create statement
			Statement statement = connection.createStatement();
			// step4:- execute query
			int result = statement.executeUpdate("insert into project values('ty118', 'sagarika3', '8/2/2023', 'selenium', 'planning', 10)");
			if (result == 1) {
				System.out.println("data added successfully");
			}
		} finally {
			connection.close();
			System.out.println("connection closed");
		}
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String un = "rmgyantra";
		String pwd = "rmgy@9999";
		String projectid = "ty118";
		driver.get("http://rmgtestingserver:8084");
		String titleRmg = driver.getTitle();
		if (titleRmg.equals("React App")) {
			System.out.println("welcome rmg page displayed");
		}
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		List<WebElement> list = driver
				.findElements(By.xpath("//tr/td[1]"));
		for (WebElement ele : list) {
			String text = ele.getText();
			if (text.equals(projectid)) {
				System.out.println(projectid + " present in rmg Ui");
				break;
			}
		}
	}

}


////th[text()='ProjectId']/../..following-sibling::tbody/tr/td[1]
