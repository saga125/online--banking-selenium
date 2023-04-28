package com.user;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.banking.reporter.*;
import com.generic.base.BaseClass;

import com.banking.enumFiles.*;
public class OpenAccountTestM extends BaseClass{
	@Test(groups = "sanity")
	public void openAccount() {
	
	    //test data
		
		String exptestCaseName = "OpenAccountTest";
		Map<String, String> map = excelUtility.getData(sheetName, exptestCaseName);
		report.info(UtilityInstanceTransfer.getExtentTest(),"test data fetched successfully");
		report.info(UtilityInstanceTransfer.getExtentTest(), map + "");
		javaUtility.consolePrint(map);
		name_ = map.get("name")+"_"+ randomNumber;
		
	homePg.openAccAction();
	
	openaccPg.sendValue(CreateAccAttr.NAME, name_);
	
	WebElement gnd =openaccPg.genderAction();
	dropdownUtility.handleDropDown(gnd, map.get("gender"));
	
	openaccPg.sendValue(CreateAccAttr.MOBILE, map.get("mobile"));
	openaccPg.sendValue(CreateAccAttr.EMAIL, map.get("email"));
	openaccPg.sendValue(CreateAccAttr.LANDLINE, map.get("landline"));
	
	openaccPg.dobAction().click();
	openaccPg.dobAction().sendKeys(map.get("DOB"));
	
	openaccPg.sendValue(CreateAccAttr.PANNO, map.get("PAN"));
	openaccPg.sendValue(CreateAccAttr.CITIZENSHIP, map.get("citizenship"));
	openaccPg.sendValue(CreateAccAttr.HOMEADDRESS, map.get("homeaddress"));
	openaccPg.sendValue(CreateAccAttr.OFFICEADDRESS, map.get("officeaddress"));
	
	WebElement state =  openaccPg.stateAction();
	dropdownUtility.handleDropDown(state, map.get("state"));
	
	WebElement city = openaccPg.cityAction();
	dropdownUtility.handleDropDown(city, map.get("city"));
	
	openaccPg.sendValue(CreateAccAttr.PIN, map.get("pin"));
	openaccPg.sendValue(CreateAccAttr.AREALOC, map.get("area"));
	openaccPg.sendValue(CreateAccAttr.NOMINEENAME, map.get("nomineename"));
	openaccPg.sendValue(CreateAccAttr.NOMINEEACCNO, map.get("nomineeacno"));
	
	WebElement accType = openaccPg.accTypeAction();
	dropdownUtility.handleDropDown(accType, map.get("acctype"));
	
	openaccPg.submitAction();
	openaccPg.confirmAction();
	
//	waitUtility.waitUntilPresenceOfAlert();
//	waitUtility.pause(5000);
	
	String tx = popupUtility.getDataFromAlert(driver);
	String applNum = tx.replaceAll("[^0-9]", "");
	popupUtility.acceptAlert(driver);
	
	commonPg.clickTab(TabNames.STAFFLOGIN);
	stafflgnPg.lgnAction(javaUtility.decode(username), javaUtility.decode(password));
	staffPg.clickButton(StaffButtons.APPROVEPENDINGACCOUNT);
	appPndAcPg.approvePendingAccountAction(applNum);
	
	//waitUtility.waitUntilPresenceOfAlert();
	//waitUtility.pause(10000);
	
	String tx1 = popupUtility.getDataFromAlert(driver);
	String accNo = tx1.replaceAll("[^0-9]", "");
	popupUtility.acceptAlert(driver);
	
	commonPg.logoutAction();

	stafflgnPg.lgnAction(javaUtility.decode(username), javaUtility.decode(password));
	
	staffPg.clickButton(StaffButtons.VIEWACTIVECUSTOMER);	
	
	viewActCustPg.accNoVerification(accNo);
}
}