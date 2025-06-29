package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import actions.ActionTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod(onlyForGroups = {"dataDriven"})
    public void browserInitForDataDriven() throws IOException {
        initBrowser();
    }

    @AfterMethod(onlyForGroups = {"dataDriven"})
    public void closeBrowserForDataDriven() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    @BeforeTest(alwaysRun = true)
    public void browserInitForNormalTests() throws IOException {
        initBrowser();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowserForNormalTests() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    public void initBrowser() throws IOException {
        String url = ConfigReader.getProperty("url");
        String browsername = ConfigReader.getProperty("browser");

        WebDriver localDriver = null;

        if (browsername.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            localDriver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            localDriver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            localDriver = new EdgeDriver();
        }

        driver.set(localDriver);

        ActionTest.implicitwait(getDriver(), 20);
        getDriver().get(url);
        ActionTest.maxmize(getDriver());
    }
}
