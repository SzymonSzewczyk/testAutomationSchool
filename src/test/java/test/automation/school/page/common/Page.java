package test.automation.school.page.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.automation.school.assertion.common.Assertion;
import test.automation.school.scenario.common.Scenario;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public <G extends Page, T extends Assertion<G>> T check(T assertion) {
        assertion.setPage((G)this);
        return assertion;
    }

    public <Input extends Page, Output extends Page> Output run(Scenario<Input, Output> scenario) {
        return scenario.run((Input) this);
    }

    public <T> T waitUntil(ExpectedCondition<T> expectedCondition) {
        return waitUntil(expectedCondition, 10);
    }

    public <T> T waitUntil(ExpectedCondition<T> expectedCondition, int timeoutSeconds) {
        return new WebDriverWait(driver, timeoutSeconds)
                .pollingEvery(Duration.ofMillis(100))
                .until(expectedCondition);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
