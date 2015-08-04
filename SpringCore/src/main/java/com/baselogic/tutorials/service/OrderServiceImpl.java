package com.baselogic.tutorials.service;

import com.baselogic.tutorials.dao.OrderDAO;
import com.baselogic.tutorials.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baselogic.tutorials.util.ExampleUtils;


/**
 * {@link ExampleService} with hard-coded input data.
 */
@Component
public class OrderServiceImpl implements OrderService {

	public static String staticFunction(){
		return "staticFunction";
	}

	@Autowired
	private OrderDAO orderDao;

	@Autowired
	private ExampleUtils exampleUtils;


	//@Autowired
	private String message;

	public String callsFunctionInOrder(){

		String result = "OrderServiceImpl: callsFunctionInOrder()";

		result += ": " + exampleUtils.nestedFunction();

		result += ": " + exampleUtils.nestedFunctionTwo();

		return result;
	}

	public String complexFunctions(){

		String result = "OrderServiceImpl: nestedFunction()";

		result += ": " + privateFunction("privateFunction");

		result += ": " + localFunction();

		result += ": " + ExampleUtils.staticFunction();

		result += ": " + exampleUtils.nestedFunctionTwo();

		return result;
	}

	public String duplicateCallsFunction() {

		String result = "OrderServiceImpl: duplicateCallsFunction()";

		for (int i = 0; i < 4; i++) {

			result += ": " + exampleUtils.nestedFunction();
		}

		return result;
	}

	public String executeInternalPrivate(){

		String result = "OrderServiceImpl: executeInternalPrivate()";

		result += ": " + privateFunction();

		result += ": " + privateFunction("privateFunction");

		return result;
	}

	//----- Mockable methods --------------------------------------------------------//

	/**
	 * Reads next record from input
	 */
	@Override
	public String getMessage() {
		return message;
	}

	public String getProxiedMessage() {
		return getMessage();
	}

	public String localFunction(){

		String result = "OrderServiceImpl: localFunction";

		try {

			result += ": " + exampleUtils.nestedFunction();

		} catch (Exception e){

			result += ": " + e.getMessage();
		}

		return result;
	}

	@Override
	public Order placeOrder(Order order) throws Exception{

		return orderDao.placeOrder(order);
	}

	public Order placeOrder2(Order order)throws Exception{

		// pass by value ** BeanFactoryPostProcessor
		//
		// or pass by reference ** BeanPostProcessor
		order.setDescription("modified description");

		return orderDao.placeOrder(order);
	}

	private String privateFunction() {
		return "OrderServiceImpl: privateFunction";
	}

	/*public String shadowedeFunction(){

		String result = "OrderServiceImpl: shadowedeFunction()";

		result = exampleUtils.nestedFunction();

		result = localFunction();

		return result;
	}*/

	private String privateFunction(String privateString) {
		return "OrderServiceImpl: privateFunction: " + privateString;
	}

	public String staticFunctions(){

		String result = "OrderServiceImpl: function()";

		try {

			result += ": " + ExampleUtils.staticFunction(); // Static Call

		} catch (Exception e){

			result += ": " + e.getMessage();
		}


		result += ": " + staticFunction();

		return result;
	}

	public String voidedFunction(){

		String result = "OrderServiceImpl: localFunction";

		try {

			exampleUtils.voidMethod();

		} catch (Exception e){

			result += ": " + e.getMessage();
		}

		return result;
	}


}
