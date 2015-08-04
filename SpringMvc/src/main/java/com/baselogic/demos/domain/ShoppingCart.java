package com.baselogic.demos.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HibernateConfiguration
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html">Objectives</a><br>
 *
 * @author Mick Knutson
 * at_see Blog: <a href="http://www.baselogic.com">http://baselogic.com</a><br>
 * at_see LinkedIN: <a href="http://linkedin.com/in/mickknutson">http://linkedin.com/in/mickknutson</a><br>
 * at_see Twitter: <a href="http://twitter.com/mickknutson">http://twitter.com/mickknutson</a><br>
 * at_see Github: <a href="http://github.com/mickknutson">http://github.com/mickknutson</a><br>
 *
 * at_see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a><br>
 * at_see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a><br>
 *
 * @since 2012
 *
 */
public class ShoppingCart {

	private final ArrayList<Item> items;

	public ShoppingCart() {
		this.items = new ArrayList<Item>();
	}

	public void addItem(Item itm) {
		this.items.add(itm);
	}

	public int getItemCount() {
		return items.size();
	}

	public Double getTotalPrice() {

		Double total = new Double(0);

		for (Item item : this.items) {
			total += item.getPrice();
		}
		return total;
	}

	private final Map<Customer, List<Item>> entries = new HashMap<Customer, List<Item>>();

	public void add(final Customer customer, final Item item) {
		List<Item> purchases;
		if (entries.containsKey(customer)) {
			purchases = entries.get(customer);
		} else {
			purchases = new ArrayList<Item>();
		}
		purchases.add(item);
		entries.put(customer, purchases);
	}

	public List<Item> getProductsByUser(final Customer customer) {
		return entries.get(customer);
	}
}
