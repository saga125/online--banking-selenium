package tyPractice;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WriteUICheckDB {

	public static void main(String[] args) throws SQLException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//write in ui
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("SeleniumAuto");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Mily");
		WebElement drop = driver.findElement(By.name("status"));
		Select s = new Select(drop);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//verify in db
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			//step3:- create statement
			Statement statement = connection.createStatement();
			//step4:- execute query
			ResultSet result = statement.executeQuery("Select * from project");
			int size = result.getMetaData().getColumnCount();
			for (int i=1; i<=size; i++) {
				System.out.println(result.getMetaData().getColumnName(i));
			}
			
			//iterate data and verify or fetch
			while (result.next()) {
				String manager = result.getString("created_by");
				String projectName = result.getString("project_name");
				String projectID = result.getString("project_id");
				String status = result.getString("status");
				String createdOn = result.getString("created_on");
				String teamSize = result.getString("team_size");
				if (projectName.equals("SeleniumAuto")) {
				System.out.println(projectName+" "+manager+" "+projectID+" "+status+" "+createdOn+" "+" "+teamSize+" ");
				}
			}
		}
			finally {
				//step6:- close connection
				connection.close();
				System.out.println("connection closed");
			}
	}

}
