package utils;

import java.text.SimpleDateFormat;
import java.util.Date;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportFramework 
{

	private static ExtentReports extent;
	//ThreadLocal< >

	public static ExtentReports GetReportObj()
	{
		 Date d = new Date();
	        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	        String timestamp = dateformat.format(d);
	        
		//responsible to make or create all configurations to your report
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir") +"\\frameworkreports\\"+timestamp+"index.html");
		reporter.config().setReportName("Automation results");
		reporter.config().setDocumentTitle("Test results");
		
		
		//responsible to crate / consolidate all your test execution results
		 try {
			extent=new ExtentReports();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Raghuvaran");
		
		return extent;
		
		
	}
}
