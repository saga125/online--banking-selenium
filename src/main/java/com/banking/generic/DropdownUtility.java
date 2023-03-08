package com.banking.generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtility {

	/**
	 * This method is used to select option from single select dropdown based on value
	 * @param element
	 * @param value
	 */
	
	public void handleDropDown(WebElement element, String value) {
		Select indDD = new Select(element);
		indDD.selectByValue(value);
	}
	
	/**
	 * This method is used to select option from single select dropdown based on visible text
	 * @param visibleText
	 * @param element
	 */
	public void handleDropDown(String visibleText, WebElement element) {
		Select indDD = new Select(element);
		indDD.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method is used to select option from single select dropdown based on index of option
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select indDD = new Select(element);
		indDD.selectByIndex(index);		
	}
	
}
