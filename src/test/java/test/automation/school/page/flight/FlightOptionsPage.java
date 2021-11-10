package test.automation.school.page.flight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.automation.school.page.common.Page;

import java.util.*;

public class FlightOptionsPage extends AbstractFlightsPage {

    @FindBy(xpath = "//tbody//td[2]")
    private List<WebElement> flights;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> rows;

    @FindBy(css = ".btn-small")
    private List<WebElement> buttons;

    public FlightOptionsPage(WebDriver driver) {
        super(driver);
    }

    public TrawellerFormPage clickFlightButton(int rowNumber) {
        buttons.get(rowNumber).click();
        return new TrawellerFormPage(driver);
    }

    public List<WebElement> getFlights() {
        return flights;
    }
}
