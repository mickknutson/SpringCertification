package com.baselogic.demos.thucydides.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Reflects results page functionality.
 *
 * @author warlock
 */
@At("#HOST/find.*")
@DefaultUrl("http://www.imdb.com/find.*")
public class ResultsPage extends PageObject {

    /**
     * @see PageObject#PageObject(WebDriver)
     */
    public ResultsPage(final WebDriver driver) {
        super(driver);
    }

    /**
     * @see PageObject#PageObject(WebDriver, int)
     */
    public ResultsPage(final WebDriver driver, final int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    /**
     * Verifies if there is at least one result for given query string.
     *
     * @param queryString query string
     */
    public void containsAtLeastOneResult(final String queryString) {
        shouldBeVisible(By
                        .xpath("//table//a[contains(translate(text(), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), '"
                                        + queryString.toUpperCase() + "')]"));
    }

}
