package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import actions.ActionTest;
import base.BaseTest;
import utils.ExtentReportFramework;

public class ListernersTest implements ITestListener
{

	ExtentReports report= ExtentReportFramework.GetReportObj();
	 ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
	
		   
		    test=report.createTest(result.getMethod().getMethodName());
		System.out.println("On test start  "+result.getName());	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On test success  "+result.getName());
		test.log(Status.PASS, "Status is passed");
		
	}

	@Override
    public void onTestFailure(ITestResult result) {
        System.out.println("On test failure  " + result.getName());
       
            try {
				ActionTest.takeScreensot(result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      
    }



	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("On test skipped  "+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On test start  "+result.getName());
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On start  "+context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("On finish  "+context.getName());
		report.flush();
		
	}
	

}
