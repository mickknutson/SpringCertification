package com.baselogic.demos.jbehave.pages;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

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
public class HomePage extends Page {

	public HomePage(Selenium selenium, ConditionRunner runner) {
		super(selenium, runner);
	}

	@Override
	public void verifyPage() {
		textIsVisible("Welcome to JPetStore 5");
		textIsVisible("Copyright Apache Software Foundation");
	}

	public StoreFrontPage clickEnterStoreLink(){
		clickLink("Enter the Store");
		waitForPageToLoad();
		return new StoreFrontPage(selenium, runner);
	}

}
