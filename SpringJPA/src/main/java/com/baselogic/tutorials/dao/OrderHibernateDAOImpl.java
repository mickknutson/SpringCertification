package com.baselogic.tutorials.dao;

import java.util.Random;

import org.springframework.stereotype.Repository;

import com.baselogic.tutorials.domain.Order;

/**
 * HibernateConfiguration
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html">Objectives</a><br>
 *
 * @author Mick Knutson
 * at_see Blog: <a href="http://www.baselogic.com">http://baselogic.com</a><br>
 * at_see LinkedIN: <a href="http://linkedin.com/in/mickknutson">http://linkedin.com/in/mickknutson</a><br>
 * at_see Twitter: <a href="http://twitter.com/mickknutson">http://twitter.com/mickknutson</a><br>
 * at_see Github: <a href="http://github.com/mickknutson">http://github.com/mickknutson</a><br>
 *
 * at_see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a><br>
 * at_see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a><br>
 *
 * @since 2012
 *
 */
@Repository
public class OrderHibernateDAOImpl implements OrderDAO {

	public Order placeOrder(Order order){
		Long id = new Random(1234567890L).nextLong();
		order.setId(id);
		return order;
	}

}
