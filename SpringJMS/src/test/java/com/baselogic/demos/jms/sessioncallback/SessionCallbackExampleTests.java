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

package com.baselogic.demos.jms.sessioncallback;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This example demonstrates using the JMS {@link Session} within
 * a callback. In this case, the {@link JmsTemplate} has no
 * <code>defaultDestination</code> property set beforehand.
 * Therefore, the destination is determined within the scope
 * of the callback implementation. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="applicationContext.xml")
public class SessionCallbackExampleTests {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Test
	public void testSessionCallback() {
		
		jmsTemplate.execute(new SessionCallback<Object>() {
			@Override
			public Object doInJms(Session session) throws JMSException {
				Queue queue = session.createQueue("someQueue");
				MessageProducer producer = session.createProducer(queue);
				Message message = session.createTextMessage("Hello Queue!");
				producer.send(message);
				return null;
			}
		});

	}

}
