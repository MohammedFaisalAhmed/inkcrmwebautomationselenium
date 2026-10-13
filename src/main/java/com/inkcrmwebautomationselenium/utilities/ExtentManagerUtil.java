package com.inkcrmwebautomationselenium.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManagerUtil
{

	static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	static ExtentReports extentReports;
	
	public static ExtentReports getExtentReports()
	{
		if(extentReports==null)
		{
			SimpleDateFormat sdp = new SimpleDateFormat("yyyyMMdd_HHmmss");
			String timeStamp =sdp.format(new Date());
			ExtentSparkReporter esr= new ExtentSparkReporter("test-output/ExtentReports_"+timeStamp+".html");
			esr.config().setDocumentTitle("Automation-Report");
			esr.config().setReportName("Test-execution report");
			
			extentReports = new ExtentReports();
			extentReports.attachReporter(esr);
			
		}
		return extentReports;
	}
	
	public static ExtentTest getTest()
	{
		return extentTest.get();
	}
	
	public static synchronized void createTest(String testName)
	{
		ExtentTest test = getExtentReports().createTest(testName);
		extentTest.set(test);
	}
	
	public static void flushreport()
	{
		if(extentReports!=null)
		{
			extentReports.flush();
		}
	}
	
	
	
	
}
