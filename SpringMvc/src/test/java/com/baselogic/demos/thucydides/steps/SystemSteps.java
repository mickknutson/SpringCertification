package com.baselogic.demos.thucydides.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.baselogic.demos.thucydides.pages.ResultsPage;
import com.baselogic.demos.thucydides.pages.WelcomePage;

/**
 * Defines steps taken by system during the application usage.
 *
 * @author warlock
 */
public class SystemSteps extends ScenarioSteps {

    /**
     * Constructs new instance.
     *
     * @param pages
     */
    public SystemSteps(final Pages pages) {
        super(pages);
    }

    @Step("the system presents at least one result")
    public void presentsAtLeastOneResult() {
        final ResultsPage page = getPages().currentPageAt(ResultsPage.class);
        page.containsAtLeastOneResult("Sherlock Holmes");
    }

    @Step("the system presents welcome page")
    public void presentsWelcomePage() {
        final WelcomePage page = getPages().get(WelcomePage.class);
        page.open();
    }
}
