package test.automation.school.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v95.browser.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Factory for different types of drivers.
 */
public class RemoteWebDriverFactory extends WebDriverFactory {
    private String gridUrl = ResourceBundle.getBundle("config").getString("grid.url");

    protected WebDriver getFirefoxDriver() {
        Capabilities capabilities = new DesiredCapabilities("firefox", "96", Platform.WINDOWS);
        try {
            return new RemoteWebDriver(new URL(gridUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected WebDriver getChromeDriver() {
        Capabilities capabilities = new DesiredCapabilities("chrome", "94", Platform.WINDOWS);
        try {
            return new RemoteWebDriver(new URL(gridUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected WebDriver getInternetExplorerDriver() {
        throw new RuntimeException("IE Not supported");
    }
}