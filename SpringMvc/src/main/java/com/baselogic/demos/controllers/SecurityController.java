package com.baselogic.demos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	
	@RequestMapping(value = "/secured", method = RequestMethod.GET)
	public String secured(Model model) {
		logger.info("SecurityController:: Secured location");
		
		model.addAttribute("authority", "generic");		
		return "secured";
	}
	
	@RequestMapping(value = "/secured/customer/home", method = RequestMethod.GET)
	public String securedCustomer(Model model) {
		logger.info("SecurityController:: securedCustomer location");
		
		model.addAttribute("authority", "customer");
		return "secured";
	}
	
	@RequestMapping(value = "/secured/user/home", method = RequestMethod.GET)
	public String securedUser(Model model) {
		logger.info("SecurityController:: securedUser location");
		
		model.addAttribute("authority", "user");
		return "secured";
	}
	
	@RequestMapping(value = "/secured/admin/home", method = RequestMethod.GET)
	public String admin(Model model) {
		logger.info("SecurityController:: Secured Admin location");
		
		return "admin";
	}
	
}
