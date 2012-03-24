package com.baselogic.demo.remote;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * http://localhost:8080/demo/GreetingService
 * @author MKnuts6173c
 *
 */
@Service("GreetingServiceEndpoint")
@WebService(serviceName = "greetingService")
public class GreetingServiceEndpoint {

	@Autowired
	private GreetingComponent greetingComponent;

	@WebMethod
	public String sayHello() {
		return greetingComponent.sayHello();
	}

}
