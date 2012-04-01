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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * A simple logger to be used as a Message Driven POJO.
 */
public class SimpleLogger {
private static final Logger logger = LoggerFactory.getLogger(SimpleLogger.class);
	public void log(String s) {
		logger.debug("Received a String: {}", s);
	}
	
	public void log(byte[] bytes) {

    String content = "";
		for (int i = 0; i < bytes.length; i++) {
			content += bytes[i];
			if (i != (bytes.length -1)) {
				content += ',';
			}
		}
        logger.debug("Received a byte array: [[]]");
	}
	
	public void log(Map map) {
		logger.debug("Received a Map: {}", map);
	}

	public void log(Money money) {
		logger.debug("Received Money: {}", money);
	}
	
}
