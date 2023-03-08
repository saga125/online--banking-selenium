package testNGPractice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.banking.generic.JavaUtility;
import com.banking.generic.SeleniumUtility;

public class BaseClass1 {
	public SeleniumUtility sUtil;
	public JavaUtility jUtil;
	public WebDriver driver;
	
	@AfterSuite
	public void suitTearDown() {
		System.out.println("AfterSuit");
	}
	
	@AfterTest
	public void testTearDown() {
		System.out.println("AfterTest");
	}
	
	@AfterClass
	public void classTearDown() {
		System.out.println("AfterClass");
	}
	@AfterMethod
    public void methodTearDown() {
		System.out.println("AfterMethod");
	}
	
	@BeforeSuite
	public void suiteSetUp() {
		System.out.println("BeforeSuit");
	}
	
	@BeforeTest
	public void testSetUp() {
		System.out.println("BeforeTest");
		sUtil = new SeleniumUtility();
		jUtil = new JavaUtility();
		driver= sUtil.launchBrowser("chrome");
	}
	
	@BeforeClass
	public void classSetUp() {
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod
	public void methodSetUp() {
		System.out.println("BeforeMethod");
	}
	
}
