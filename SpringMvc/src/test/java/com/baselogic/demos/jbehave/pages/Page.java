package com.baselogic.demos.jbehave.pages;

import java.util.concurrent.TimeUnit;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.Condition;
import com.thoughtworks.selenium.condition.ConditionRunner;
import com.thoughtworks.selenium.condition.Not;
import com.thoughtworks.selenium.condition.Presence;
import com.thoughtworks.selenium.condition.Text;

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
public abstract class Page {

	protected final Selenium selenium;
	protected final ConditionRunner runner;

	public Page(Selenium selenium, ConditionRunner runner) {
		this.selenium = selenium;
		this.runner = runner;
	}

	protected static void waitFor(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
		}
	}

	public void waitFor(Condition condition) {
		runner.waitFor(condition);
		waitFor(1);
	}

	public void waitForPageToLoad() {
		selenium.waitForPageToLoad("30000");
	}

	public void textIsVisible(String text) {
		waitFor(new Text(text));
	}

	public void elementIsPresent(Presence prescence) {
		waitFor(prescence);
	}

	public void imageIsPresent(String srcAttributeValue) {
		String xpath = "//img[@src='" + srcAttributeValue + "']";
		elementIsPresent(new Presence(xpath));
	}

	public void textIsNotVisible(String text) {
		waitFor(new Not(new Text(text)));
	}

	public void clickLink(String link) {
		selenium.click("link=" + link);
	}

	public void open(String url) {
		selenium.open(url);
	}

	public void type(String locator, String value) {
		selenium.type(locator, value);
	}

	public void clickButton(String buttonLocator) {
		selenium.click(buttonLocator);
	}

	public abstract void verifyPage();

}
