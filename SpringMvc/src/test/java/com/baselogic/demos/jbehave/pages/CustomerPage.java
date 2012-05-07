package com.baselogic.demos.jbehave.pages;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends AbstractPage {

	public CustomerPage(WebDriverProvider driverProvider, String baseUrl) {
		super(driverProvider, baseUrl);
    }

    public void open(){
		findElement(By.linkText("/customer.html")).click();
    }

    public void pageIsShown() {
		found("Spring's form tags example");
    }

	public void enterText(String field, String input) {
		findElement(By.name(field)).sendKeys(input);
	}

    public void find(String step) {
        findElement(By.name("matchingStep")).sendKeys(step);
        findElement(By.name("findButton")).click();
    }

    public void viewWithMethods() {
        new Select(findElement(By.name("viewSelect"))).selectByVisibleText("WITH_METHODS");
    }

    public void sortByPattern() {
        new Select(findElement(By.name("sortingSelect"))).selectByVisibleText("BY_PATTERN");
    }

	public void runIsSuccessful(int timeoutInSecs) {
		waitFor(timeoutInSecs);

		String output = findElement(By.id("storyOutput")).getText();

		assertTrue("Scenario should have been in story output",
				output.contains("Scenario"));
		assertFalse("Nothing should have failed", output.contains("FAILED"));
		assertFalse("Nothing should be pending", output.contains("PENDING"));

	}

}
