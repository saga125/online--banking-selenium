package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.generic.InteractionUtility;

public class HomePage {
    //declaration
	@FindBy(xpath = "//li[text()='Open Account']") private WebElement openAcc;
	@FindBy(xpath = "//li[text()='Apply Debit Card']") private WebElement applDC;
	@FindBy(xpath = "//a[contains(text(),'Internet Banking')]") private WebElement Ib;
	@FindBy(xpath = "//li[text()='Login ']") private WebElement lgn;
	@FindBy(xpath = "//li[text()='Register']") private WebElement regstr;
	@FindBy(xpath = "//li[text()='Fund Transfer']") private WebElement fundtrns;
	
	//Initialisation
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilisation --> business logic
	public void openAccAction() {
		openAcc.click();
	}
	
	public void applDebitCard() {
		applDC.click();
	}
	
	public void IbAction(InteractionUtility arg) {
		arg.mouseHover(Ib);
	}
	
	public void lgnAction() {
		lgn.click();
	}
	public void regstrAction() {
		regstr.click();
	}
	public void fundtrnsAction() {
		fundtrns.click();
	}
}
