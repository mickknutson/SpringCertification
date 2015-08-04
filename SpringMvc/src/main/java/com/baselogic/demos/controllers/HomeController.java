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
 * HomeController
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html">Objectives</a><br>
 *
 * @author Mick Knutson
 * at_see Blog: <a href="http://www.baselogic.com">http://baselogic.com</a><br>
 * at_see LinkedIN: <a href="http://linkedin.com/in/mickknutson">http://linkedin.com/in/mickknutson</a><br>
 * at_see Twitter: <a href="http://twitter.com/mickknutson">http://twitter.com/mickknutson</a><br>
 * at_see Github: <a href="http://github.com/mickknutson">http://github.com/mickknutson</a><br>
 *
 * at_see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a><br>
 * at_see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a><br>
 *
 * @since 2012
 *
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
