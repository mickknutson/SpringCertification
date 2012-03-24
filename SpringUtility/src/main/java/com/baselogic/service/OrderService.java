package com.baselogic.service;

import com.baselogic.domain.Order;

public interface OrderService {
	
	String getMessage();

	Order placeOrder(Order order);

}
