package test.automation.school.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Factory for different types of drivers.
 * This can be controlled via command line parameter.
 */
public class RemoteWebDriverFactory extends WebDriverFactory {
    private String gridUrl = ResourceBundle.getBundle("config").getString("grid.url");

    protected WebDriver getFirefoxDriver() {
        Capabilities capabilities = DesiredCapabilities.firefox();
        try {
            return new RemoteWebDriver(new URL(gridUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected WebDriver getChromeDriver() {
        Capabilities capabilities = DesiredCapabilities.chrome();
        try {
            return new RemoteWebDriver(new URL(gridUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected WebDriver getInternetExplorerDriver() {
        Capabilities capabilities = DesiredCapabilities.internetExplorer();
        try {
            return new RemoteWebDriver(new URL(gridUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}