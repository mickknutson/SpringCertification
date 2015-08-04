package com.baselogic.tutorials.common;

import com.baselogic.tutorials.dao.OrderDAOImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

/**
 * SimpleBean
 *
 * @since 2012
 *
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SimpleBean {

    OrderDAOImpl orderDao;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


    public void setOrderDao(OrderDAOImpl orderDao){
        this.orderDao = orderDao;
    }

	@Override
	public String toString() {
		return "SimpleBean [message=" + message + "]";
	}
}
