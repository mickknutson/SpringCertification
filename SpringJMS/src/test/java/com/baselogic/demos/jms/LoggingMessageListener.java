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

package com.baselogic.demos.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * A simple implementation of {@link MessageListener} that logs 
 * the text of any received {@link TextMessage}.
 */
public class LoggingMessageListener implements MessageListener {

	private static Logger logger = LoggerFactory.getLogger(LoggingMessageListener.class);
	
	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				String text = ((TextMessage) message).getText();
				logger.info("Received: " + text);
			}
			catch (JMSException e) {
                logger.error(e.getLocalizedMessage(), e);
				e.printStackTrace();
			}
		}
	}

}
