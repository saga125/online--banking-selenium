package com.banking.generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtility {
	JavascriptExecutor js;
	
	/**
	 * 
	 * @param driver
	 */
	public JavascriptUtility(WebDriver driver) {
		js = (JavascriptExecutor)driver;
	}
	
	/**
	 * 
	 */
	public void scrollDown() {
		js.executeScript("Window.scrollBy(0, document.body.scrollHeight)");
	}
	/**
	 * 
	 */
	public void scrollUp() {
		js.executeScript("Window.scrollBy(0, -document.body.scrollHeight)");
	}
	/**
	 * 
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * 
	 * @param element
	 */
	public void click(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * 
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element, String data) {
		js.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	/**
	 * 
	 * @param url
	 */
	public void launchApplication(String url) {
		js.executeScript("Window.location=arguments[0]", url);
	}
	
	public void highlight(WebElement element) {
		js.executeScript("arguments[0].setAttribute('style', 'border: 6px dotted red;');", element);
	}
	
}
