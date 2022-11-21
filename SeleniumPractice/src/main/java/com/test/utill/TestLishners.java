package com.test.utill;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestLishners extends CommonMethods implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		
		System.out.println("***n Test Started "+ result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		
		System.out.println("*** Test Success :"+ result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		System.out.println("*** Test Failed :"+ result.getName());
		takeScreenshot(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		System.out.println("*** Test Skipped :"+ result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		System.out.println("*** Test finished :"+ context.getName());
	}
	
	

}
