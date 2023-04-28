package com.banking.listener;

import java.io.IOException;

import org.testng.IClassListener;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.generic.base.BaseClass;

public class ListenerImplementation implements ITestListener{
	


@Override
public void onFinish(ITestContext context) {
	
}

@Override
public void onStart(ITestContext context) {
	
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
}

@Override
public void onTestFailedWithTimeout(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestFailedWithTimeout(result);
}

@Override
public void onTestFailure(ITestResult result) {
	System.out.println("onTestFailure");
	try {
		BaseClass.class.cast(result.getMethod().getInstance()).seleniumUtility.getScreenShot(result.getMethod().getRealClass().getSimpleName(),BaseClass.class.cast(result.getMethod().getInstance()).javaUtility);
	}catch(IOException e) {
		e.printStackTrace();
	}

}

@Override
public void onTestSkipped(ITestResult result) {
	System.out.println("onTestSkipped");
}

@Override
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestStart(result);
}

@Override
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestSuccess(result);
}
}
