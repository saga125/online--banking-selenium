package com.banking.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author DELL
 *
 */

public class WaitUtility {
	private WebDriverWait wait;
	private WebDriver driver;
	
	/**
	 * 
	 * @param driver
	 * @param timeout
	 */
	public WaitUtility(WebDriver driver, long timeout) {
		this.driver = driver ;
		wait = new WebDriverWait(driver , timeout);
	}
	
	/**
	 * 
	 * @param milisecond
	 */

	public void pause(long milisecond) {
			try {
				Thread.sleep(milisecond);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * 
	 * @param driver
	 * @param timeout
	 */
	public void waitForElementLoad(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public void waitUntilVisible(String xpath) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
	}
	
	public void waitUntilClickable(String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}
	
	public void waitUntilInvisible(String xpath) {
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath((xpath)))));
	}
	
	public void waitUntilInvisibleOfText(String xpath, String text) {
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(xpath),text));
	}
	
	public void waitUntilPresenceOfAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * 
	 * @param pollingTime
	 * @param duration
	 * @param element
	 * @throws InterruptedException4
	 */
	public void waitTillClick(long pollingTime, int duration, WebElement element) throws InterruptedException {
		int count = 0;
		while(count<duration) {
			try{
				element.click();
				break;
			}catch(Exception e){
				Thread.sleep(pollingTime);
				count++;
			}
			
		}
	}
	
}
