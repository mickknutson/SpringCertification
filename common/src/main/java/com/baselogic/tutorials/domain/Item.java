package com.baselogic.tutorials.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Item
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * @since 2012
 *
 */
public class Item {

	private Long id;

	private Order order;

	private String product;

	private double price;

	private int quantity;

	public Item() {}

	public Item(String product, double price, int quantity) {
		super();
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
