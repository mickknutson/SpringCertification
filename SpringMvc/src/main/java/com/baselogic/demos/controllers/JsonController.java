package com.baselogic.demos.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HibernateConfiguration
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
public class JsonController {

	private static final Logger logger = LoggerFactory.getLogger(JsonController.class);

	@RequestMapping(value = "/echo", method = RequestMethod.GET)
	public String echo(Model model) {
		logger.info("JsonController:: echo {}, {}");

		model.addAttribute("message", "No message entered");

		return "echo";
	}

	@RequestMapping(value = "/echo/{message}", method = RequestMethod.GET)
	public String echo(@PathVariable String message, Model model) {
		logger.info("JsonController:: echo {}", message);

		model.addAttribute("message", message + "--> no second message");

		return "echo";
	}

	@RequestMapping(value = "/echo/{message}/{message2}", method = RequestMethod.GET)
	public String echo(@PathVariable String message, @PathVariable String message2, Model model) {
		logger.info("JsonController:: echo {}, {}", message, message2);

		model.addAttribute("message", message + "-->" + message2);

		return "echo";
	}

	@RequestMapping(value = "/json/{applicationName}/{eventType}",
					method = RequestMethod.GET,
					produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> fooJson(@PathVariable String applicationName, @PathVariable String eventType) {

		String json = "{\"level\" : \"INFO\", \"thread\" : \"main\", \"applicationName\" : \""
					  + applicationName + "\", \"eventType\" : \""
					  + eventType
					  + "\"}";

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		logger.info("JsonController:: json {}", json);

		return new ResponseEntity<String>(json,
										  responseHeaders,
										  HttpStatus.CREATED);
	}

}
