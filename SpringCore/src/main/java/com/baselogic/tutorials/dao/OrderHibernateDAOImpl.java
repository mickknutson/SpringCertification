package com.baselogic.tutorials.dao;

import java.util.Random;

import com.baselogic.tutorials.domain.Order;
import org.springframework.stereotype.Repository;


@Repository
public class OrderHibernateDAOImpl implements OrderDAO {

    // BEFORE....
    @Override
    public Order placeOrder(Order order){
		Long id = new Random(1234567890L).nextLong();
		order.setId(id);
        // after
		return order;
	}
    // AFTER Returning...

//    @Override
//    public Order placeOrder(Order order)
//            throws Exception{
//
//        if(order.getId() != null){
//            throw new Exception("Order ID exists");
//        }
//
//        Long id = new Random(1234567890L).nextLong();
//        order.setId(id);
//        order.adviceGiven.add("OrderHibernateDAOImpl.placeOrder()");
//        return order;
//    }

    @Override
    public Order placeDelayedOrder(Order order, long delay)
            throws Exception{

        if(order.getId() != null){
            throw new Exception("Order ID exists");
        }

        Thread.sleep(delay);

        Long id = new Random(1234567890L).nextLong();
        order.setId(id);
//        order.adviceGiven.add("OrderHibernateDAOImpl.placeDelayedOrder()");
        return order;
    }

}
