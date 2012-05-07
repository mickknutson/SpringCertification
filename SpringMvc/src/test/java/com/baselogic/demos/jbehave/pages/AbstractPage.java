package com.baselogic.demos.jbehave.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public abstract class AbstractPage extends WebDriverPage {

	private String baseUrl;

	public AbstractPage(WebDriverProvider driverProvider, String baseUrl) {
        super(driverProvider);
		this.baseUrl = baseUrl;
    }

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void found(String text) {
        found(getPageSource(), text);
    }

    public void found(String pageSource, String text) {
        if (!pageSource.contains(escapeHtml(text))) {
            fail("Text: '" + text + "' not found in page '" + pageSource + "'");
        }
    }

    public void found(List<String> texts) {
        for (String text : texts) {
            found(text);
        }
    }

    public void notFound(String text) {
        notFound(getPageSource(), text);
    }

    public void notFound(String pageSource, String text) {
        assertThat(pageSource.contains(escapeHtml(text)), is(false));
    }

    private String escapeHtml(String text) {
        return text.replace("<", "&lt;").replace(">", "&gt;");
    }

	public void waitFor(int timeoutInSecs) {
		try {
			TimeUnit.SECONDS.sleep(timeoutInSecs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
