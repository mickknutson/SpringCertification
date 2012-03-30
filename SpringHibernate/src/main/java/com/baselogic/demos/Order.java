package com.baselogic.demos;


import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * An order.
 */
@Entity

//@Table is equal to (name="Order")
@Table(name="T_ORDER")
public class Order {
	
	// column="id"
	@Id
	// Sequence Generator
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	// No Annotation needed.
	// column="customer"
	@Column(name="CUST")
	private String customer;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ORDER_ID")
	private Collection<Item> items = new LinkedHashSet<Item>();
	
	// List's contain Objects in insertion order.
	// Set's contain unique objects.

	
	
	
	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the items
	 */
	public Collection<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
}
