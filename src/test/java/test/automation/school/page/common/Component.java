package test.automation.school.page.common;

import org.openqa.selenium.WebDriver;
import test.automation.school.page.common.Page;

public abstract class Component extends Page {
    public Component(WebDriver driver) {
        super(driver);
    }
}
