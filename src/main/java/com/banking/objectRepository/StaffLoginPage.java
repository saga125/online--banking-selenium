package com.banking.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {
      @FindBy (xpath = "//input[@name='staff_id']") private WebElement username;
      @FindBy (xpath = "//input[@name='password']") private WebElement password;
      @FindBy (xpath = "//input[@type='submit']") private WebElement lgnBtn;
      
      public StaffLoginPage(WebDriver driver){
    	  PageFactory.initElements(driver, this);
      }
      
      public void lgnAction(String uname, String psword) {
    	  username.sendKeys(uname);
    	  password.sendKeys(psword);
    	  lgnBtn.click();
      }
      
}
