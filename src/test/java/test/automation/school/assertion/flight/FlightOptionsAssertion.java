package test.automation.school.assertion.flight;

import org.openqa.selenium.WebElement;
import test.automation.school.assertion.common.Assertion;
import test.automation.school.page.flight.FlightOptionsPage;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class FlightOptionsAssertion extends Assertion<FlightOptionsPage> {

	public FlightOptionsAssertion verifyFlightNumberOrder(List<String> expectedFlights) {
		List<String> actualFlights = page.getFlights().stream()
				.map(WebElement::getText)
				.collect(Collectors.toList());
		assertEquals("Flights are not in expected order", expectedFlights, actualFlights);
		return this;
	}

	public FlightOptionsAssertion verifyFlightNumbersUnordered(Set<String> expectedFlights) {
		Set<String> actualFlights = page.getFlights().stream()
				.map(WebElement::getText)
				.collect(Collectors.toSet());
		assertEquals("Flights are not in expected order", expectedFlights, actualFlights);
		return this;
	}

	public FlightOptionsAssertion verifyWaitUntilCanBeUsed() {
		assertTrue(page.waitUntil(condition -> !page.getFlights().isEmpty()), "Flights table is empty!");
		return this;
	}
}
