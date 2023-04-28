package com.banking.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApprovePendingAccountPage {
	@FindBy(xpath="//input[@placeholder='Application number']") private WebElement appNoTxBx;
	@FindBy(xpath="//input[@name='search_application']") private WebElement searchIcon;
	@FindBy(xpath="//input[@name='approve_cust']") private WebElement approveBtn;
	@FindBy(xpath="//input[@name='logout_btn']") private WebElement logoutBtn;
	
	/**
	 * 
	 * @param driver
	 */
	public ApprovePendingAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @param applicationNo
	 * @throws InterruptedException 
	 */
	public void approvePendingAccountAction(String applicationNo) {
		appNoTxBx.sendKeys(applicationNo);
		searchIcon.click();
		approveBtn.click();
	}
	
	public void logoutAction() {
		logoutBtn.click();
	}
	
} 
