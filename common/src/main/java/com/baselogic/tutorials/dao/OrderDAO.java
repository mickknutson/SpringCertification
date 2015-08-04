package com.baselogic.tutorials.dao;


import com.baselogic.tutorials.domain.Order;

/**
 * OrderDAO
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * @since 2012
 *
 */
public interface OrderDAO {

	Order placeOrder(Order order) throws Exception;

	Order placeDelayedOrder(Order order, long delay) throws Exception;

}
