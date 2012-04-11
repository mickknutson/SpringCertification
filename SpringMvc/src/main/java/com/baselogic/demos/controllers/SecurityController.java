package com.baselogic.demos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * HibernateConfiguration
 * 
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html">Objectives</a><br />
 *
 * @author Mick Knutson
 * @see Blog: <a href="http://www.baselogic.com">http://baselogic.com</a><br />
 * @see LinkedIN: <a href="http://linkedin.com/in/mickknutson">http://linkedin.com/in/mickknutson</a><br />
 * @see Twitter: <a href="http://twitter.com/mickknutson">http://twitter.com/mickknutson</a><br />
 * @see Github: <a href="http://github.com/mickknutson">http://github.com/mickknutson</a><br />
 * 
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a><br />
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a><br />
 * 
 * @since 2012
 * 
 */
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
