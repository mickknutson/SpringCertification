package com.baselogic.demos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)

@Transactional(propagation=Propagation.SUPPORTS, 
		       readOnly=true, 
		       isolation = Isolation.DEFAULT
)
public class OrderPersistenceTests {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	/*@Transactional(propagation=Propagation.REQUIRES_NEW, 
				   readOnly=false, 
				   isolation = Isolation.READ_COMMITTED,
				   rollbackFor = ItemNotAvailable.class,
				   noRollbackFor = ItemShippingIsDelayed.class
				   timeout = 25L
	)*/
	public void testSaveOrderWithItems() throws Exception {
		
		Order order = new Order();
		order.getItems().add(new Item());
		
		entityManager.persist(order);
		entityManager.flush();
		
		assertNotNull(order.getId());
	}

	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		
		Order order = new Order();
		order.getItems().add(new Item());
		
		entityManager.persist(order);
		entityManager.flush();
		
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		
		Order other = (Order) entityManager.find(Order.class, order.getId());
		
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

	@Test
	@Transactional
	public void testSaveAndFind() throws Exception {
		
		Order order = new Order();
		Item item = new Item();
		item.setProduct("bar");
		order.getItems().add(item);
		
		entityManager.persist(order);
		entityManager.flush();
		
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		
		Order other = (Order) entityManager
				.createQuery(
						"select o from Order o join o.items i where i.product=:product")
				.setParameter("product", "bar")
				.getSingleResult();
		
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

}
