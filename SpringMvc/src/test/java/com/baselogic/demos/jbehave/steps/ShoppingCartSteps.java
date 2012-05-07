package com.baselogic.demos.jbehave.steps;

import java.util.List;
import junit.framework.Assert;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.baselogic.demos.domain.Customer;
import com.baselogic.demos.domain.Item;
import com.baselogic.demos.domain.ShoppingCart;

/**
 * ShoppingCartSteps
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
public class ShoppingCartSteps {

	private final Customer customer;
	private final ShoppingCart shoppingCart;
	private Item item;

	public ShoppingCartSteps() {
		this.customer = new Customer();
		this.shoppingCart = new ShoppingCart();
	}

	@Given("a customer")
	public void givenACustomer() {
		// customer = new Customer();
		// shoppingCart = new ShoppingCart();
	}

	@Given("a shopping cart")
	public void givenAShoppingCart() {
		// shoppingCart = new ShoppingCart();
	}

	@Given("an item")
	public void givenAnItem() {
		item = new Item();
		item.setProduct("Coffee");
	}

	@When("the customer adds the item to the shopping cart")
	public void whenTheCustomerAddsTheItemToTheShoppingCart() {
		shoppingCart.add(customer, item);
	}

	@Then("the item must be included in the list of the shoppingcart's entries")
	public void thenTheItemMustBeIncludedInTheListOfTheShoppingcartsEntries() {
		List<Item> entries = shoppingCart.getProductsByUser(customer);
		Assert.assertTrue(entries.contains(item));
	}

}
