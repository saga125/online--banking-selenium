package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCardPage {
	private WebDriver driver;
	private String tabPartialXpath = "//input[@name='%s']";
	
	private WebElement convertToWebElement(String partialXpath, String replaceData) {
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	//Initialisation
			public ApplyDebitCardPage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
     //Business Logic 
			public void sendValues(ApplyDCTxFlds txFlds, String data) {
				convertToWebElement(tabPartialXpath, txFlds.getTxFld()).sendKeys(data);
			}
			
			public void clickAction(ApplyDCTxFlds txFlds) {
				convertToWebElement(tabPartialXpath, txFlds.getTxFld()).click();
			}
}
