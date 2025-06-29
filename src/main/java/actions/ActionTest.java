package actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;

public class ActionTest 
{

	
	public static void implicitwait(WebDriver driver,long sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public static void maxmize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public static void waitUntilElementVisisble(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static String takeScreensot(String testName) throws IOException {
        try {
		Date d = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateformat.format(d);

        TakesScreenshot screenshot = (TakesScreenshot)BaseTest.getDriver();
        File ScreenshotTaken = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/TakingScreenshots/failedscreens_" + testName + "_" + timestamp + ".png";
        File destFile=new File(destination);
        FileUtils.copyFile(ScreenshotTaken, destFile);
        return  destFile.getAbsolutePath();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;  // ❌ This will cause the error if not handled
        }
        
    }
	
}
