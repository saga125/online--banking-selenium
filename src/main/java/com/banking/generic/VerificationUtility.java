package com.banking.generic;

/**
 * 
 * @author DELL
 *
 */
public class VerificationUtility {
	
    /**
     * 
     * @param actual
     * @param expected
     */
	public void exactVerify(String actual, String expected, String strategy, String pageNameOrTCname) {
		if (strategy.equalsIgnoreCase("TC")) {
			if (actual.equals(expected)) {
				System.out.println(pageNameOrTCname+" TC is pass");
			}
			else {
				System.out.println(pageNameOrTCname+" TC is fail");
			}
		}
		else if (strategy.equalsIgnoreCase("page")) {
			if (actual.equals(expected)){
				System.out.println(pageNameOrTCname + " Page Displayed");
			}
			else {
				System.out.println(pageNameOrTCname + " Page not Displayed");
			}
		}
		else if (strategy.equalsIgnoreCase("element")) {
			if (actual.equals(expected)) {
				System.out.println(pageNameOrTCname+ " is showing");
			}
			else {
				System.out.println(pageNameOrTCname+ " is not showing");
			}
		}
	}
	
	public void partialVerify(String actual, String expected, String strategy, String pageNameOrTCname) {
		if (strategy.equalsIgnoreCase("TC")) {
			if (actual.contains(expected)) {
				System.out.println(pageNameOrTCname+" TC is pass");
			}
			else {
				System.out.println(pageNameOrTCname+" TC is fail");
			}
		}
		else if (strategy.equalsIgnoreCase("page")) {
			if (actual.contains(expected)){
				System.out.println(pageNameOrTCname + " Page Displayed");
			}
			else {
				System.out.println(pageNameOrTCname + " Page not Displayed");
			}
		}
	}
}
