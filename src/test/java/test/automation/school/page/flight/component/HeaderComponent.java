package test.automation.school.page.flight.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.automation.school.page.common.Component;
import test.automation.school.page.login.LoginPage;

public class HeaderComponent extends Component {
    @FindBy(linkText = "home")
    WebElement homeLink;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickHomeLink() {
        homeLink.click();
        return new LoginPage(driver);
    }
}
