package com.insurance.ASTL.GenericUtilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImp implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		//actual test script start from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"--------Execution Starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"-----Passed");
		Reporter.log(MethodName+"---------TestScript execution successful");
		}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		try {
			String FailedScript = WebDriverUtilities.takeScreenShot(BaseClass.sdriver, MethodName);
			test.addScreenCaptureFromPath(FailedScript);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, MethodName+"-----Failed");
		Reporter.log(MethodName+"-----Failed");
			}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"------Skipped");
		Reporter.log(MethodName);
			}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreport/report.html");
		htmlreport.config().setDocumentTitle("SDET-51");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("AEGON LIFE");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-url", "http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		report.setSystemInfo("Reporter name", "Anshu");
			}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
			}
	

}
