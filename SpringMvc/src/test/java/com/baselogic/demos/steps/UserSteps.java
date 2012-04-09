package com.baselogic.demos.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.baselogic.demos.pages.WelcomePage;

/**
 * Defines steps taken by users during the application usage.
 *
 * @author warlock
 */
public class UserSteps extends ScenarioSteps {

    /**
     * Constructs new instance.
     *
     * @param pages
     */
    public UserSteps(final Pages pages) {
        super(pages);
    }

    @Step("the user performs search for movie title existing in database")
    public void performsSearchForExistingTitle() {
        final WelcomePage page = getPages().currentPageAt(WelcomePage.class);
        page.searchForTitle("Sherlock Holmes");
    }

}
