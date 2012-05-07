package com.baselogic.demos.jbehave.steps;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import junit.framework.Assert;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.baselogic.demos.domain.Customer;
import com.baselogic.demos.domain.Item;
import com.baselogic.demos.domain.ShoppingCart;
import com.baselogic.demos.util.AppUtils;

/**
 * AppUtilsSteps
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
public class AppUtilsSteps {

	private String token;

	private String result;

	public AppUtilsSteps() {
	}

	@Given("a token")
	public void givenAToken() {
		token = "admin";
	}

	@When("the token is encoded")
	public void whenTheTokenIsEncoded() {
		result = AppUtils.encode(token);
	}

	@Then("the resulting value should be md5 encoded")
	public void thenTheResultingValueShouldBeMd5Encoded() {
		assertThat(result, is("21232f297a57a5a743894a0e4a801fc3"));
	}

}
