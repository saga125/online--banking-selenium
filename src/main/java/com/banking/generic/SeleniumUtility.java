package com.banking.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtility {

	private WebDriver driver;
	
	/**
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			 
			//	ChromeOptions options = new ChromeOptions();
			//	options.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			
			/*else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}*/
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Enter proper key");
			break;
    	}
		return driver;
	}
	/**
	 * 
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to apply implicit wait and launch application
	 * @param url
	 */
	public void launchApplication(String url) {
		driver.get(url);
	}
	/**
	 * @param width
	 * @param height
	 */
	public void resizeBrowser(int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}
	/**
	 * 
	 */
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * 
	 */
	public void closeTab() {
		driver.close();
	}
	
	public String getCurentUrl() {
		return driver.getCurrentUrl();
	}
	/**
	 * 
	 * @return
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		return path;
		
	}
	
	public String getScreenShot(WebElement ele, String elementName, JavaUtility javaUtility) throws IOException {
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/elements/"+elementName+"_"+ javaUtility.getCurrentDateTime()+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
    public String getScreenShot(String testCaseName, JavaUtility javaUtility) throws IOException {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/pages/"+testCaseName+"_"+ javaUtility.getCurrentDateTime()+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
	
}
