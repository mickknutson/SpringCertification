package com.baselogic.demo.remote;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("greetingComponent")
public class GreetingComponent {
	
	public String sayHello() {
		System.out.println("Hello World!");
		return "Hello World!";
	}
	
	public String sayHello(String name) {
		System.out.println("Hello " + name);
		return "Hello " + name;
	}
}

