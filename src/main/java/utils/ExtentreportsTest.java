package utils;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentreportsTest 
{
	ExtentReports extent;
	ExtentTest test;
	@BeforeTest
	public void extentRports()
	{
		//responsible to make or create all configurations to your report
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir") +"\\reports\\index.html");
		reporter.config().setReportName("Automation results");
		reporter.config().setDocumentTitle("Test results");
		
		
		
		
		//responsible to crate / consolidate all your test execution results
		 extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Raghuvaran");
		
		
	}
	
	@Test
	public void scrollingTest()
	{
		 test=extent.createTest("Scrolling test");
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/scroll-top.php");
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,1000)");
		
		js.executeScript("window.scrollBy(0,-1000)");
	
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
		js.executeScript("window.scrollTo(0, 0)");
		
		WebElement element=driver.findElement(By.xpath("//*[contains(text(),'Where can I get some?')]"));
		
		js.executeScript("arguments[0].scrollIntoView();",element);
		
		driver.close();
		extent.flush();
	

	}
	
	@Test
	public void test1() {
	    test=extent.createTest("test1");
	    try {
	        Assert.assertTrue(true); // Will fail
	        test.pass("Test passed");
	    } catch (AssertionError e) {
	        test.fail("Test failed: " + e.getMessage());
	        throw e; // re-throw so TestNG still sees the test as failed
	    } finally {
	        extent.flush();
	    }
	}

	
	@Test
	public void test2() {
	    test=extent.createTest("test2");
	    try {
	        Assert.assertTrue(false); // Will fail
	        test.pass("Test passed");
	    } catch (AssertionError e) {
	        test.fail("Test failed: " + e.getMessage());
	        throw e; // re-throw so TestNG still sees the test as failed
	    } finally {
	        extent.flush();
	    }
	}

	
	@Test
	public void test3() {
	   test= extent.createTest("test3");
	    try {
	        Assert.assertTrue(false); // Will fail
	        test.pass("Test passed");
	    } catch (AssertionError e) {
	        test.fail("Test failed: " + e.getMessage());
	        throw e; // re-throw so TestNG still sees the test as failed
	    } finally {
	        extent.flush();
	    }
	}

	
}
