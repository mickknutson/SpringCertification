package com.baselogic.demos.jbehave.pages;

import org.jbehave.web.selenium.WebDriverProvider;

public class Pages {

	private final WebDriverProvider driverProvider;

	private final String baseUrl;

    private Home home;
	private CustomerPage customerPage;

	public Pages(WebDriverProvider driverProvider, String baseUrl) {
        this.driverProvider = driverProvider;
		this.baseUrl = baseUrl;
    }

    public Home home(){
        if ( home == null ){
			home = new Home(driverProvider, baseUrl);
        }
        return home;
    }

	public CustomerPage customerPage() {
		if (customerPage == null) {
			customerPage = new CustomerPage(driverProvider, baseUrl);
        }
		return customerPage;
    }

}
