package com.baselogic.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baselogic.service.UsageTracked;

/**
 * {@link ExampleService} with hard-coded input data.
 */
@Component
public class ParentalAdvisor implements UsageTracked {
	
	private static final Logger logger = LoggerFactory.getLogger(ParentalAdvisor.class);

	public String trackUsage() {
		return ">>> --- trackUsage() >>>";
	}
   
}
