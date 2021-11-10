package test.automation.school.page.flight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.automation.school.page.common.Page;

public class TrawellerFormPage extends AbstractFlightsPage {

    @FindBy(id = "inputName")
    private WebElement name;

    @FindBy(xpath = "//input[@value='Purchase Flight']")
    private WebElement purchaseFlightButton;

    public TrawellerFormPage(WebDriver driver) {
        super(driver);
    }

    public TrawellerFormPage setUserName(String textName) {
        name.sendKeys(textName);
        return this;
    }

    public OrderSummaryPage clickPurchaseFlight() {
        purchaseFlightButton.click();
        return new OrderSummaryPage(driver);
    }
}
