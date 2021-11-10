package test.automation.school.page.flight;

import org.openqa.selenium.WebDriver;
import test.automation.school.page.common.Page;
import test.automation.school.page.flight.component.HeaderComponent;

public class AbstractFlightsPage extends Page {

    private HeaderComponent header;

    public AbstractFlightsPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }

    public HeaderComponent getHeader() {
        return header;
    }
}
