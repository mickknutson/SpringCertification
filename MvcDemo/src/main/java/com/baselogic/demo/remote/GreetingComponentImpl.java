package com.baselogic.demo.remote;

public class GreetingComponentImpl {
	
	public String sayHello() {
		System.out.println("Hello World!");
		return "Hello World!";
	}
	
	public String sayHello(String name) {
		System.out.println("Hello " + name);
		return "Hello " + name;
	}
}

