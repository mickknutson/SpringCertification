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

import java.io.Serializable;


public class Money implements Serializable {

	private static final long serialVersionUID = 6100332361468140399L;

	private double amount;
	private String type;
	
	public Money(double amount, String type) {
		this.amount = amount;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return amount + " [" + type + "]";
	}
}
