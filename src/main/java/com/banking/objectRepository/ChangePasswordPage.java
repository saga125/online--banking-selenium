package com.banking.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	@FindBy (name="oldpass") private WebElement oldpswdTxBx;
	@FindBy (name="cnfrm") private WebElement cnfrmOldpswdTxBx;
	@FindBy (name="newpass") private WebElement newPswdTxBx;
	@FindBy (name="change_pass") private WebElement submitBtn;
	
	public ChangePasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void changePasswordAction(String oldpasswrd, String cnfrmoldpasswrd, String newPasswrd) {
		oldpswdTxBx.sendKeys(oldpasswrd);
		cnfrmOldpswdTxBx.sendKeys(cnfrmoldpasswrd);
		newPswdTxBx.sendKeys(newPasswrd);
		submitBtn.click();
	}
}
