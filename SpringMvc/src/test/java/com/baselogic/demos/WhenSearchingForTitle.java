package com.baselogic.demos;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.baselogic.demos.requirements.Application.MovieSearch.SearchForTitles;
import com.baselogic.demos.steps.SystemSteps;
import com.baselogic.demos.steps.UserSteps;

@RunWith(ThucydidesRunner.class)
@Story(SearchForTitles.class)
public class WhenSearchingForTitle {

    @ManagedPages(defaultUrl = "http://www.imdb.com")
    protected transient Pages pages;

    @Steps
    protected transient SystemSteps system;

    @Steps
    protected transient UserSteps user;

    @Managed
    protected transient WebDriver webdriver;

    @Test
    @Ignore
    public void shouldBeAbleToSearchForExistingTitle() {
        system.presentsWelcomePage();
        user.performsSearchForExistingTitle();
        system.presentsAtLeastOneResult();
    }
}
