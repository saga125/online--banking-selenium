package com.banking.listener;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.banking.generic.FrameworkConstants;
import com.banking.generic.JavaUtility;
import com.banking.generic.PropertyKey;
import com.banking.generic.PropertyUtility;
import com.banking.generic.ReportUtility;
import com.banking.generic.Misc.Report;
import com.banking.generic.Misc.UtilityInstanceTransfer;

import testNGBankingSystem.BaseClass;

public class ExtentReportsListener implements ITestListener, ISuiteListener{
	private ReportUtility report;
	public static ReportUtility sreport;
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish ---> Test");
		report.saveReport();
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("OnStart ---> Test");
		}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		report.fail(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is failed", result.getThrowable());
		String screenshotPath = BaseClass.class.cast(result.getMethod().getInstance()).seleniumUtility.getScreenShot();
		report.attachScreenshot(UtilityInstanceTransfer.getExtentTest(), screenshotPath, result.getMethod().getMethodName(), "base64");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		report.skip(UtilityInstanceTransfer.getExtentTest(), "<b>"+ result.getMethod().getMethodName() + "SKIPPED");
		report.skip(UtilityInstanceTransfer.getExtentTest(),result.getThrowable());
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.author());
		report.addCategory(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		report.pass(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+"PASS");
	}
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart --->Suit");
		PropertyUtility propertyUtility  = null;
		try {
			propertyUtility = new PropertyUtility(FrameworkConstants.TEST_PROPERTY_FILE_PATH);
		}catch(IOException e) {
			e.printStackTrace();
		}
		report = new ReportUtility();
		String overrideOrNot = propertyUtility.getPropertyData(PropertyKey.OVERRIDEREPORT);
		String randomName = "";
		if (overrideOrNot.equalsIgnoreCase("no")) {
			randomName = "_"+new JavaUtility().getCurrentDateTime();
		}
		report.init(propertyUtility.getPropertyData(PropertyKey.EXTENTREPORTTITLE)+"ExtentReport"+randomName, propertyUtility.getPropertyData(PropertyKey.EXTENTREPORTNAME), propertyUtility.getPropertyData(PropertyKey.BROWSER));
		sreport = report;
	}

}
