package com.baselogic.domain;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * An order.
 */
public class Order {
	
	private Long id;
	
	private String description;
	
	private Collection<Item> items = new LinkedHashSet<Item>();

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
