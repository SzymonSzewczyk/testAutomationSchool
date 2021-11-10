package test.automation.school.page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.automation.school.page.common.Page;
import test.automation.school.page.login.component.HeaderComponent;

public class LoginPage extends Page {

    private HeaderComponent header;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }

    public LoginPage clickLoginButton() {
        submitButton.click();
        return this;
    }

    public HeaderComponent getHeader() {
        return header;
    }
}
