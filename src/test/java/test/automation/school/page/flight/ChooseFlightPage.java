package test.automation.school.page.flight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import test.automation.school.page.common.Page;

public class ChooseFlightPage extends AbstractFlightsPage {

    @FindBy(name = "fromPort")
    private WebElement from;

    @FindBy(name = "toPort")
    private WebElement to;

    @FindBy(xpath = "//input[@value='Find Flights']")
    private WebElement findButton;

    public ChooseFlightPage(WebDriver driver) {
        super(driver);
    }

    public ChooseFlightPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public ChooseFlightPage selectDepartureCity(String city) {
        new Select(from).selectByValue(city);
        return this;
    }

    public ChooseFlightPage selectDestinationCity(String city) {
        new Select(to).selectByValue(city);
        return this;
    }


    public FlightOptionsPage clickFindFlights() {
        findButton.click();
        return new FlightOptionsPage(driver);

    }
}
