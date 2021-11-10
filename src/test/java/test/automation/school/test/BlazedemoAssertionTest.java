package test.automation.school.test;


import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.automation.school.assertion.flight.FlightOptionsAssertion;
import test.automation.school.assertion.flight.OrderSummaryAssertion;
import test.automation.school.page.flight.ChooseFlightPage;
import test.automation.school.scenario.PickFlightScenario;
import test.automation.school.scenario.PurchaseScenrio;
import test.automation.school.test.common.SeleniumTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * blazedemo.com tests
 */
public class BlazedemoAssertionTest extends SeleniumTest
{
    private List<String> flightNumbersOrderVA = Arrays.asList("43", "234", "9696", "12", "4346");
    private Set<String> flightNumbersUnordered = new HashSet<>(Arrays.asList("12", "43", "9696", "4346", "234"));
    private String url;

    @BeforeClass(alwaysRun = true)
    @Parameters({"url"})
    public void blazedemoAssertionClassSetup(ITestContext context, String url) {
        this.url = url;
    }

    /**
     * Verifies if flight numbers are displayed in right order
     * And if all flight are there, no matter in what order
     */
    @Test(groups = {"SMOKE"})
    public void airlinesTest() {
        new ChooseFlightPage(driver, url)
                .run(new PickFlightScenario("Paris", "Bunos Aires"))
            .check(new FlightOptionsAssertion())
                .verifyFlightNumberOrder(flightNumbersOrderVA)
                .verifyFlightNumbersUnordered(flightNumbersUnordered);
    }

    @Test(groups = {"UI_REGRESSION"})
    public void bookFlight() {
        new ChooseFlightPage(driver, url)
                .run(new PickFlightScenario("Paris", "Buenos Aires"))
                .clickFlightButton(0)
                .run(new PurchaseScenrio("Adam"))
                .check(new OrderSummaryAssertion())
                    .verifyTextIsPresent("Thank you");
    }


}
