package com.baselogic.tutorials.dao;

import java.util.Random;

import org.springframework.stereotype.Repository;

import com.baselogic.tutorials.domain.Order;

@Repository
public class OrderHibernateDAOImpl implements OrderDAO {

	public Order placeOrder(Order order)
			throws Exception{

		if(order.getId() != null){
			throw new Exception("Order ID exists");
		}

		Long id = new Random(1234567890L).nextLong();
		order.setId(id);
		order.adviceGiven.add("OrderHibernateDAOImpl.placeOrder()");
		return order;
	}

	public Order placeDelayedOrder(Order order, long delay)
			throws Exception{

		if(order.getId() != null){
			throw new Exception("Order ID exists");
		}

		Thread.sleep(delay);

		Long id = new Random(1234567890L).nextLong();
		order.setId(id);
		order.adviceGiven.add("OrderHibernateDAOImpl.placeDelayedOrder()");
		return order;
	}

}
