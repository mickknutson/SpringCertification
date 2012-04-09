package com.baselogic.domain;

import java.util.ArrayList;
import java.math.BigDecimal;

public class ShoppingCart{
	
	private ArrayList<Item> items;
	
	private Order order;
	
	public ShoppingCart(){
		this.items = new ArrayList<Item>();
	}
	
	public void addItem(Item itm){
		this.items.add(itm);
	}
	
	public int getItemCount(){
		return items.size();
	}
	
	public Double getTotalPrice(){
		
		Double total = new Double(0);
		
		for(Item item : this.items){
		  total += item.getPrice();
		}
		return total;
	}
}