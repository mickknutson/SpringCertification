package com.baselogic.demos.customer.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.baselogic.demos.customer.model.Customer;

public class CustomerValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return Customer.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"required.userName", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
				"required.address", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");
			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"required.confirmPassword", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", 
				"required.sex", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "favNumber", 
				"required.favNumber", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(
				errors, "javaSkills", "required.javaSkills","Field name is required.");
		
		Customer cust = (Customer)target;
		
		if(!(cust.getPassword().equals(cust.getConfirmPassword()))){
			errors.rejectValue("password", "notmatch.password");
		}
		
		if(cust.getFavFramework().length==0){
			errors.rejectValue("favFramework", "required.favFrameworks");
		}

		if("NONE".equals(cust.getCountry())){
			errors.rejectValue("country", "required.country");
		}
		
	}
	
}