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

package com.baselogic.demos.jms.mdp;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * On the sending side, these tests demonstrate the automatic Object to Message
 * conversion capabilities of the {@link org.springframework.jms.core.JmsTemplate} which delegates to the
 * strategy provided by an implementation of the {@link org.springframework.jms.support.converter.MessageConverter}
 * interface. On the receiving side, a Message Driven POJO receives Objects
 * that have been automatically converted from each Message. The
 * {@link org.springframework.jms.listener.adapter.MessageListenerAdapter} provides the necessary bridge.
 */
@ContextConfiguration(locations = {"/samples/jms/mdp/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageDrivenPojoTests {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Test
	public void testSendingString() {
		jmsTemplate.convertAndSend("Hello POJO!");
	}

	@Test
	public void testSendingBytes() {
		byte[] bytes = new byte[] {1,2,3};
		jmsTemplate.convertAndSend(bytes);
	}

	@Test
	public void testSendingMap() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("firstName", "Keith");
		map.put("lastName", "Donald");
		jmsTemplate.convertAndSend(map);
	}

	@Test
	public void testSendingMoney() {
		Money money = new Money(100.00, "USD");
		jmsTemplate.convertAndSend(money);
	}

}
