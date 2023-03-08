package com.user;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.base.BaseClass;

import com.banking.enumFiles.*;

public class InternetBankingTestM extends BaseClass{
	
	@Test(groups = {"regression", "major"})
	public void internetBanking() {
		   //test data
		   String exptestCaseName = "InternetBankingTest";
		   Map<String, String> map = excelUtility.getData(sheetName, exptestCaseName);
		   javaUtility.consolePrint(map);
		   name_ = map.get("name")+"_"+ randomNumber;
		
		homePg.openAccAction();
		openaccPg.sendValue(CreateAccAttr.NAME, name_);
		
		WebElement gnd = openaccPg.genderAction();
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
		
		waitUtility.waitUntilPresenceOfAlert();
		
		String tx = popupUtility.getDataFromAlert(driver);
		String applNum = tx.replaceAll("[^0-9]", "");
		popupUtility.acceptAlert(driver);
		
		commonPg.clickTab(TabNames.STAFFLOGIN);
		stafflgnPg.lgnAction(javaUtility.decode(username), javaUtility.decode(password));
		staffPg.clickButton(StaffButtons.APPROVEPENDINGACCOUNT);
		appPndAcPg.approvePendingAccountAction(applNum);
		
		waitUtility.waitUntilPresenceOfAlert();
		
		waitUtility.pause(10000);
		
		String tx1 = popupUtility.getDataFromAlert(driver);
		String accNo = tx1.replaceAll("[^0-9]", "");
		popupUtility.acceptAlert(driver);
		
		commonPg.logoutAction();
	
		stafflgnPg.lgnAction(javaUtility.decode(username), javaUtility.decode(password));
		
		staffPg.clickButton(StaffButtons.VIEWACTIVECUSTOMER);
		
		viewActCustPg.accNoVerification(accNo);
		
		commonPg.logoutAction();
		commonPg.clickTab(TabNames.HOME);
		
		homePg.applDebitCard();
		applyDCPg.sendValues(ApplyDCTxFlds.HOLDER_NAME, name_);
		applyDCPg.clickAction(ApplyDCTxFlds.DOB);
		applyDCPg.sendValues(ApplyDCTxFlds.DOB, map.get("DOB"));
		applyDCPg.sendValues(ApplyDCTxFlds.PAN, map.get("PAN"));
		applyDCPg.sendValues(ApplyDCTxFlds.MOB, map.get("mobile"));
		applyDCPg.sendValues(ApplyDCTxFlds.ACC_NO, accNo);
		applyDCPg.clickAction(ApplyDCTxFlds.SUBMIT);
		
		String tx3 = popupUtility.getDataFromAlert(driver);
		String str1 = tx3.replaceAll("[^0-9]", " ");
		String str2 = str1.replaceAll(" +", " ");
		String str3 = str2.trim();
		String [] na = str3.split(" ");
		String dcn = na[0];
		String dcp = na[1];
		popupUtility.acceptAlert(driver);
		
		commonPg.clickTab(TabNames.HOME);
		homePg.IbAction(interactionUtility);
		homePg.regstrAction();
		ibRegPage.sendValues(IBRegstrtnTxFlds.HOLDER_NAME, name_);
		ibRegPage.sendValues(IBRegstrtnTxFlds.ACCNUM, accNo);
		ibRegPage.sendValues(IBRegstrtnTxFlds.DBTCARD, dcn);
		ibRegPage.sendValues(IBRegstrtnTxFlds.DBTPIN, dcp);
		ibRegPage.sendValues(IBRegstrtnTxFlds.MOBILE, map.get("mobile"));
		ibRegPage.sendValues(IBRegstrtnTxFlds.PAN_NO, map.get("PAN"));
		ibRegPage.clickAction(IBRegstrtnTxFlds.DOB);
		ibRegPage.sendValues(IBRegstrtnTxFlds.DOB, map.get("DOB"));
		ibRegPage.sendValues(IBRegstrtnTxFlds.LAST_TRANS, map.get("lasttransaction"));
		ibRegPage.sendValues(IBRegstrtnTxFlds.PASSWORD, map.get("password"));
		ibRegPage.sendValues(IBRegstrtnTxFlds.CNFRM_PASSWORD, map.get("confirmpassword"));
		ibRegPage.clickAction(IBRegstrtnTxFlds.SUBMIT);
		
		String tx4 = popupUtility.getDataFromAlert(driver);
		String custID = tx4.replaceAll("[^0-9]", "");
		popupUtility.acceptAlert(driver);
		
		commonPg.clickTab(TabNames.HOME);
		homePg.IbAction(interactionUtility);
		
		homePg.lgnAction();
		
		iblgnPage.ibLoginAction(custID, map.get("password"));
		
		String custWelcomeMsg = custIBPg.welomeMsgAction();
		Assert.assertEquals(custWelcomeMsg, "Welcome "+name_, "customer profile not displayed");
	//	verificationUtility.exactVerify(custWelcomeMsg, "Welcome "+name_ , "page", "Customer profile");
	}
	
}
