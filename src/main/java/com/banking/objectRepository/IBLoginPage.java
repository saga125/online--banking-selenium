package com.banking.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IBLoginPage {
	
	//declaration
	@FindBy (name ="customer_id") private WebElement custIdTxBx;
    @FindBy (name ="password") private WebElement passwrdTxBx;
    @FindBy (name ="login-btn") private WebElement loginBtn;
	
    /**
     * Initialisation
     * @param driver
     */
    public IBLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Business Logic 
	 * @param custoId
	 * @param password
	 */
    public void ibLoginAction(String custoId, String password) {
		custIdTxBx.sendKeys(custoId);
		passwrdTxBx.sendKeys(password);
		loginBtn.click();
	}
}
