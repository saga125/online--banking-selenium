package com.banking.generic.Misc;

import org.testng.annotations.Test;

import com.banking.generic.ReportUtility;

public class ExtentReportPractice {
	
	@Test
	public void report() {
		ReportUtility report = new ReportUtility();
		report.createTest("Test1");
		report.info(UtilityInstanceTransfer.getExtentTest(), "a1");
		report.info(UtilityInstanceTransfer.getExtentTest(), "b1");
		report.info(UtilityInstanceTransfer.getExtentTest(), "c1");
		report.createTest("Test2");
		report.info(UtilityInstanceTransfer.getExtentTest(), "a2");
		report.info(UtilityInstanceTransfer.getExtentTest(), "b2");
		report.info(UtilityInstanceTransfer.getExtentTest(), "c2");
		report.saveReport();
	}
}
