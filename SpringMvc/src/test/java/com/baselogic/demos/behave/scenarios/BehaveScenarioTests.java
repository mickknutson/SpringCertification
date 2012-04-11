package com.baselogic.demos.behave.scenarios;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Assert;
import org.junit.Test;

import com.baselogic.demos.domain.Customer;
import com.baselogic.demos.domain.Item;
import com.baselogic.demos.domain.ShoppingCart;

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
public class BehaveScenarioTests extends JUnitStory {
	private Customer customer;
	private ShoppingCart shoppingCart;
	private Item item;

	@Given("a customer")
	public void aCustomer() {
		customer = new Customer();
	}

	@Given("a shopping cart")
	public void aShoppingCart() {
		shoppingCart = new ShoppingCart();
	}

	@Given("an item")
	public void anItem() {
		item = new Item();
		item.setProduct("Coffee");
	}

	@When("the customer adds the item to the shopping cart")
	public void userAddsProductToShoppingCart() {
		shoppingCart.add(customer, item);
	}

	@Then("the item must be included in the list of the shoppingcart's entries")
	public void itemMustBeListed() {
		List<Item> entries = shoppingCart.getProductsByUser(customer);
		Assert.assertTrue(entries.contains(item));
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(
				new LoadFromClasspath(getClass().getClassLoader()))
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withFormats(Format.CONSOLE));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), this)
				.createCandidateSteps();
	}

	@Override
	@Test
	public void run() throws Throwable {
		super.run();
	}
}
