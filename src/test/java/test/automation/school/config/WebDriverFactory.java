package test.automation.school.config;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class WebDriverFactory {

    public WebDriver getDriver(DriverType browser) {
        WebDriver driver = null;
        switch (browser) {
            case FIREFOX:
                driver = getFirefoxDriver();
                break;
            case CHROME:
                driver = getChromeDriver();
                break;
            case IE:
                driver = getInternetExplorerDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    abstract protected WebDriver getFirefoxDriver();
    abstract protected WebDriver getChromeDriver();
    abstract protected WebDriver getInternetExplorerDriver();
}
