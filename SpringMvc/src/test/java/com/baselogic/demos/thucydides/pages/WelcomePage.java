package com.baselogic.demos.thucydides.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Reflects welcome page functionality.
 *
 * @author warlock
 */
@DefaultUrl("http://www.imdb.com/")
public class WelcomePage extends PageObject {

    @FindBy(id = "navbar-query")
    private transient WebElement queryString;

    @FindBy(id = "quicksearch")
    private transient WebElement searchType;

    @FindBy(id = "navbar-submit-button")
    private transient WebElement submitButton;

    /**
     * @see PageObject#PageObject(WebDriver)
     */
    public WelcomePage(final WebDriver driver) {
        super(driver);
    }

    /**
     * @see PageObject#PageObject(WebDriver, int)
     */
    public WelcomePage(final WebDriver driver, final int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    /**
     * Performs search for the title.
     *
     * @param queryString query string
     */
    public void searchForTitle(final String queryString) {
        selectFromDropdown(searchType, "Titles");
        enter(queryString).into(this.queryString);
        submitButton.click();
    }

}
