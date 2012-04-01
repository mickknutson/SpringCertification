/*
 * Copyright 2002-2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baselogic.demos.jms.producercallback;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.ProducerCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This example demonstrates using the {@link MessageProducer} in a 
 * callback. It also sends multiple messages so that the affect of
 * modifications to the receiving Message listener container's
 * <code>concurrentConsumers</code> property can be demonstrated.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "applicationContext.xml")
public class ProducerCallbackExampleTests {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Destination destination;

	@Test
	public void testProducer() throws Exception {
		
		jmsTemplate.execute(new ProducerCallback<Object>() {
			@Override
			public Object doInJms(Session session, MessageProducer producer) throws JMSException {
				for (int i = 1; i <= 10; i++) {
					Message message = session.createTextMessage("Hello #" + i);
					producer.send(destination, message);
				}
				return null;
			}
		});
	}
}
