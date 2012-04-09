package com.baselogic.demos.controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * Request Mapping:
	 * http://localhost:8080/SpringMVC/
	 * 
	 * Method to execute: home()
	 * 
	 * View Resolution:
	 * Prefix:         /WEB-INF/views/
	 * Logical Name:   home
	 * Suffix:         .jsp
	 * View File location: /WEB-INF/views/home.jsp
	 * 
	 * Possible method signatures:
	 * ---------------------------
	 * 	public String home(Locale locale, ModelAndView modelAndView)
	 * public ModelAndView home(ModelAndView modelAndView)
	 * public void home(ModelAndView modelAndView)
	 * public String home(Locale locale, Model model)
	 * public String home(Model model)
	 * public void home(Model model)
	 * public void home() { // defaults view name to name of method. ie 'home'
	 * public void home(HttpServletRequest request, HttpServletResponse response)
	 * public String home(Model model, HttpServletRequest request, HttpServletResponse response)
	 * public String home(String pathVariable, Model model, HttpServletRequest request, HttpServletResponse response)
	 * 
	 */		
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		@SuppressWarnings({ "serial" })
		List<String> items = new ArrayList<String>(){{ //orderService.findAllProducts()
			add("Foo");
			add("bar");
			add("baz");
		}};
		
		model.addAttribute("items", items);
		
		model.addAttribute("serverTime", formattedDate );
		
		// Logical View Name
		return "home"; 
	}
	
}
