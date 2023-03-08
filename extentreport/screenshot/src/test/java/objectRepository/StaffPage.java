package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StaffPage {
	private WebDriver driver;
	//declaration
	private String buttonPartialXpath = "//input[@value='%s']";
	//input[@value='Approve Pending Account']
	//input[@value='View Active Customer']
	//input[@value='Delete Customer A/c']
	//input[@value='Credit Customer']
	//input[@value='View Customer by A/c No']

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

/**
 * Initialisation
 * @param driver
 */
public StaffPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

/**
 * Business Logic 
 * @param tabName
 */
public void clickButton(StaffButtons btnName) {
	convertToWebElement(buttonPartialXpath, btnName.getButton()).click();
}

}