package com.baselogic.demos.thucydides;

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

import com.baselogic.demos.thucydides.requirements.Application.MovieSearch.SearchForTitles;
import com.baselogic.demos.thucydides.steps.SystemSteps;
import com.baselogic.demos.thucydides.steps.UserSteps;

/**
 * HibernateConfiguration
 * 
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html">Objectives</a><br />
 *
 * @author Mick Knutson
 * @see Blog: <a href="http://www.baselogic.com">http://baselogic.com</a><br />
 * @see LinkedIN: <a href="http://linkedin.com/in/mickknutson">http://linkedin.com/in/mickknutson</a><br />
 * @see Twitter: <a href="http://twitter.com/mickknutson">http://twitter.com/mickknutson</a><br />
 * @see Github: <a href="http://github.com/mickknutson">http://github.com/mickknutson</a><br />
 * 
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a><br />
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a><br />
 * 
 * @since 2012
 * 
 */
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
