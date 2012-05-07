package com.baselogic.demos.jbehave.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class Home extends AbstractPage {

	public Home(WebDriverProvider driverProvider, String baseUrl) {
		super(driverProvider, baseUrl);
    }

    public void open() {
		get(getBaseUrl());
        manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
