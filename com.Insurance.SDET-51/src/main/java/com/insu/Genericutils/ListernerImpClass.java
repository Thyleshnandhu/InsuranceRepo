package com.insu.Genericutils;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListernerImpClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		//actual testscript execution statrs from here
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"--->Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"---passed");
		Reporter.log(MethodName+"---Testscript executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		try {
			String failedScript= WebDriverUtility.takeScreenShot(BaseClass.sdriver, MethodName);
			test.addScreenCaptureFromPath(failedScript);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, MethodName+"--->failed");
		Reporter.log(MethodName+"---> failed");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"--->skipped");
		Reporter.log(MethodName+"---> skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		//create report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./Extentreport/report.html");
		
		htmlReport.config().setDocumentTitle("SDET-51");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Insurance");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		report.setSystemInfo("Reporter Name", "Thyleshwari");
		
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	

}
