package com.baselogic.tutorials.service;

import com.baselogic.tutorials.domain.Order;

/**
 * OrderService
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * @since 2012
 *
 */
public interface OrderService {

	String getMessage() throws Exception;

	Order placeOrder(Order order) throws Exception;

}
