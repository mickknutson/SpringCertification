package com.baselogic.demos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPersistenceTests {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	@Transactional
	public void testSaveOrderWithItems() throws Exception {

		Session session = sessionFactory.getCurrentSession();
		
		Order order = new Order();
		order.getItems().add(new Item());
		
		session.save(order);
		
		// Don't be lazy:
		session.flush();
		
		assertNotNull(order.getId());
		
		// get Item from Order, and item.getId() != null
		
		System.out.println("================================================");
		System.out.println("order: " + order.toString());
		System.out.println("================================================");
	}

	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		
		Session session = sessionFactory.getCurrentSession();
		
		Order order = new Order();		
		order.getItems().add(new Item());
		
		session.save(order);
		session.flush();
		
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		
		Order other = (Order) session.get(Order.class, order.getId());
		
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

	@Test
	@Transactional
	public void testSaveAndFind() throws Exception {
		
		Session session = sessionFactory.getCurrentSession();
		
		Order order = new Order();
		
		Item item = new Item();
		item.setProduct("bar");
		order.getItems().add(item);
		
		/*Item item2 = new Item();
		item.setProduct("foo");
		order.getItems().add(item2);*/
		
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		session.clear();
		
		// Hibernate Query Language (HQL)
		Order other = (Order) session
				.createQuery( "select o from Order o join o.items i where i.product = :product")				
				.setString("product", "bar")
				.uniqueResult();
		
		assertNotNull(other);
		
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

}
