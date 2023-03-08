package com.banking.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.banking.enumFiles.*;

public class OpenAccountPage {
	private WebDriver driver;
	//declaration
	private String txBoxPartialXpath = "//input[@name='%s']";
//	private String txBoxNameAttr = " ";
	@FindBy (xpath = "//select[@name='gender']") private WebElement gender;
	@FindBy (name = "dob") private WebElement dob;
	@FindBy (xpath = "//select[@name='state']") private WebElement state;
	@FindBy (name = "city") private WebElement city;
	@FindBy (name = "acctype") private WebElement acctype;
	@FindBy (xpath = "//input[@type='submit']") private WebElement submit;
	@FindBy (xpath = "//input[@value='Confirm']") private WebElement confirm;
	

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

/*private WebElement convertToWebElementByName(String nameAttr, String replaceData) {
	String xpath = String.format(nameAttr, replaceData);
	return driver.findElement(By.name(name));
}*/


//Initialisation
public OpenAccountPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

//Business Logic 
public void sendValue(CreateAccAttr name, String data) {
	convertToWebElement(txBoxPartialXpath, name.getName()).sendKeys(data);;
}

/*public WebElement returnValue(CreateAccAttr name) {
	return convertToWebElementByName(txBoxNameAttr, name.getName());
}*/

public WebElement genderAction() {
	return gender;
}

public WebElement dobAction() {
	return dob;
}

public WebElement stateAction() {
	return state;
}

public WebElement cityAction() {
	return city;
}

public WebElement accTypeAction() {
	return acctype;
}

public void submitAction() {
	submit.click();
}

public void confirmAction() {
	confirm.click();
}
}