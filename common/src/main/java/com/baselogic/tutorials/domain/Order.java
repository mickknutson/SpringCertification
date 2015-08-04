package com.baselogic.tutorials.domain;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Order
 *
 * @since 2012
 *
 */
public class Order {

	private Long id;

	private String note;

	private String description;

	private Collection<Item> items = new LinkedHashSet<Item>();

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

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
