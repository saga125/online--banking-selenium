package com.banking.generic;

import java.util.Set;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author DELL
 *
 */
public class PopupUtility {
/**
 * 
 * @param driver
 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void closeAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * 
	 * @param driver
	 * @param data
	 */
	public void setDataToAlert(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 *
	 * @param driver
	 * @return
	 */
	public String getDataFromAlert(WebDriver driver) {
		
		return driver.switchTo().alert().getText();
	}
	
	public void switchWindow(WebDriver driver, String strategy, String verificationValue) {
		Set<String> windows = driver.getWindowHandles();
		for (String id: windows) {
			driver.switchTo().window(id);
			if (strategy.equalsIgnoreCase("exact_url")) {
				if (driver.getCurrentUrl().contains(verificationValue)) {
					break;
				}
			}
			else if (strategy.equalsIgnoreCase("partial_url")) {
				if (driver.getCurrentUrl().contains(verificationValue)) {
					break;
				}
			}
			else if(strategy.equalsIgnoreCase("exact_title")) {
				if (driver.getTitle().contains(verificationValue)) {
					break;
				}
			}
			else if(strategy.equalsIgnoreCase("partial_title")) {
				if (driver.getTitle().contains(verificationValue)) {
					break;
				}
			}
		}
	}
}
