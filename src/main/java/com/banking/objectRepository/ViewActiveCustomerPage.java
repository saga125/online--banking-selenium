package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.banking.generic.VerificationUtility;

public class ViewActiveCustomerPage {
	@FindBy(xpath="//tr/td[4]") private List<WebElement> accNoList;

/**
 * 
 * @param driver
 */
public ViewActiveCustomerPage(WebDriver driver){
	  PageFactory.initElements(driver, this);
}

/**
 * 
 * @param verifiUtility
 * @param accNum
 */
public void accNoVerification(String accNum) {
for (WebElement ele: accNoList) {
	String text = ele.getText();
	 if (text.equals(accNum)) {
		 Assert.assertEquals(text, accNum, "accNumber not found");
		// verifiUtility.exactVerify(text, accNum, "TC", "Open Account");
	}
}
}
}
