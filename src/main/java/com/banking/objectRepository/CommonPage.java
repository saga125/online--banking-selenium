package com.banking.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.enumFiles.*;

public class CommonPage {
	private WebDriver driver;
	//declaration
	private String tabPartialXpath = "//a[text()='%s']";
	@FindBy(xpath="//input[@name='logout_btn']") private WebElement logoutBtn;

	/**
	 * This method is used to convert partialXpath  String to WebElement
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	//Initialisation
			public CommonPage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
     //Business Logic 
			public void clickTab(TabNames tabName) {
				convertToWebElement(tabPartialXpath, tabName.getTab()).click();
			}
			
			public void logoutAction() {
				logoutBtn.click();
			}
	
}	
	
	
	
	
	
	
/*	@FindBy(xpath = "//a[text()='Staff Login']" ) private WebElement staffLgn;
	@FindBy(xpath = "//a[text()='Home']") private WebElement home;
	@FindBy(xpath = "//a[text()='About Us']") private WebElement aboutus;
	@FindBy(xpath = "//a[text()='Contact Us']") private WebElement contctus;
	
	
	//Utilisation --> business logic
	public void staffLgnAction() {
		staffLgn.click();
	}
	
	public void homeAction() {
		home.click();
	}*/
	




