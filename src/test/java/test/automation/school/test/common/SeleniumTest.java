package test.automation.school.test.common;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import test.automation.school.config.*;

public abstract class SeleniumTest {
    protected WebDriver driver;
    private WebDriverFactory webDriverFactory = getWebDriverFactory();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        RetryAnalyzer retryAnalyzer = new RetryAnalyzer();
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzer(retryAnalyzer);
        }
    }

    @BeforeClass(alwaysRun = true)
    public void classSetup() {
        driver = webDriverFactory.getDriver(
                DriverType.valueOf(System.getProperty("driver", "chrome").toUpperCase()));
    }

    @AfterClass(alwaysRun = true)
    public void classTeardown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriverFactory getWebDriverFactory() {
        boolean isRemote = Boolean.valueOf(System.getProperty("remote", "false"));
        return isRemote ? new RemoteWebDriverFactory() : new LocalWebDriverFactory();
    }
}
