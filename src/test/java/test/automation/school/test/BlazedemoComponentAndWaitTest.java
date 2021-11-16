package test.automation.school.test;


import org.testng.annotations.Test;
import test.automation.school.assertion.flight.FlightOptionsAssertion;
import test.automation.school.page.flight.ChooseFlightPage;
import test.automation.school.test.common.SeleniumTest;

import java.util.Arrays;
import java.util.List;

/**
 * blazedemo.com tests
 */
public class BlazedemoComponentAndWaitTest extends SeleniumTest {

	private List<String> flightNumbersOrder = Arrays.asList("43", "234", "9696", "12", "4346");

	/**
	 * Shows how to use components
	 */
	@Test(groups = {"SMOKE"})
	public void loginTest() {
		new ChooseFlightPage(driver, "http://blazedemo.com")
				.getHeader()
				.clickHomeLink()
				.clickLoginButton()
				.getHeader()
				.clickBlazeDemoLink()
				.clickFindFlights()
				.check(new FlightOptionsAssertion())
				.verifyFlightNumberOrder(flightNumbersOrder)
				.verifyWaitUntilCanBeUsed();
	}


}
