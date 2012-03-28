package com.baselogic.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.baselogic.dao.OrderDAO;


/**
 * {@link ExampleService}
 */
@Component("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleServiceImpl.class);

	@Autowired
	OrderDAO orderDao;

	@Autowired
	OrderDAO aliasedDao;
	
	//@Autowired
	String message;
	
	/**
	 * Reads next record from input
	 */
	public String getMessage() {
		return message;	
	}
	
	public void setMessage(String msg){
		this.message = msg;
	}
	
	@PostConstruct
	public void initService(){
        if (orderDao != null) {
            logger.debug("MY DEP BEAN {}", orderDao.toString());
        }
        logger.debug(">>>>> {}: @PostConstruct <<<<<", this.getClass());
	}
	
	@PreDestroy
	public void destroyService(){
		logger.debug(">>>>> {}: @PreDestroy <<<<<", this.getClass());
	}
	
}
