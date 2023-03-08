package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IBRegistrationPage {
	private WebDriver driver;
	private String txBxPartialNameAttr = "%s";
	
	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String name_ = String.format(partialXpath, replaceData);
		return driver.findElement(By.name(name_));
	}
	
	//Initialisation
	public IBRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Business Logic 
	public void sendValues(IBRegstrtnTxFlds txFlds, String data) {
		convertToWebElement(txBxPartialNameAttr, txFlds.getAttr()).sendKeys(data);
	}
	
	public void clickAction(IBRegstrtnTxFlds txFlds) {
		convertToWebElement(txBxPartialNameAttr, txFlds.getAttr()).click();
	}
}
