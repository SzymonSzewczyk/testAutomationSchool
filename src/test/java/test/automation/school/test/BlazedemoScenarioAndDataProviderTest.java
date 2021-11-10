package test.automation.school.test;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.automation.school.page.flight.ChooseFlightPage;
import test.automation.school.scenario.PickFlightScenario;
import test.automation.school.test.common.SeleniumTest;

/**
 * blazedemo.com tests
 */
public class BlazedemoScenarioAndDataProviderTest extends SeleniumTest
{
    @DataProvider(name = "myProvider")
    public Object[][] userProvider() {
        return new Object[][]{
                {"Boston", "Berlin"},
                {"Paris", "Buenos Aires"}
        };
    }

    /**
     * Verifies if flight numbers are displayed in right order
     * And if all flight are there, no matter in what order
     */
    @Test(dataProvider = "myProvider")
    public void airlinesTest(String from, String to) {
        new ChooseFlightPage(driver, "http://www.blazedemo.com")
            .run(new PickFlightScenario(from, to))
            .clickFlightButton(1);

    }
}
