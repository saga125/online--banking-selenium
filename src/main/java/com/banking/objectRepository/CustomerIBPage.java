package com.banking.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerIBPage {
	@FindBy (xpath = "//label[contains(text(),'Welcome')]") private WebElement welcomeMsg;
	@FindBy (xpath = "//li[text()='Change Password']") private WebElement changePasswordTab;
	@FindBy (name="logout_btn") private WebElement logoutBtn;

/**
 * 
 * @param driver
 */
public CustomerIBPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public String welomeMsgAction() {
	return welcomeMsg.getText();
}

public void changePasswordTabAction() {
	changePasswordTab.click();
}

public void logoutBtnAction() {
	logoutBtn.click();
}

}