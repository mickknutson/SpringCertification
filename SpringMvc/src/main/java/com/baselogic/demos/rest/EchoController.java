package com.baselogic.demos.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 * 
 * service:jmx:jmxmp://localhost:9875
 * service:jmx:rmi://localhost/jndi/rmi://localhost:1099/echo
 */
@Controller
@ManagedResource(objectName="echo:name=EchoController")
@RequestMapping(value = "/echo/command")
public class EchoController {
	
	private static final Logger logger = LoggerFactory.getLogger(EchoController.class);
	
	public static String commandPrefix = "PRE";
	
	@Autowired
	private String serviceUrl;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{command}", method = RequestMethod.GET)
	public String echo(@PathVariable("command") String command, Model model) {
		
		logger.info("serviceUrl is "+ serviceUrl +" :: "+ command);
				
		model.addAttribute("id", serviceUrl +" :: "+ command );
		
		return "echo";
	}

	@ManagedAttribute
	public static String getCommandPrefix() {
		return commandPrefix;
	}

	@ManagedAttribute
	public static void setCommandPrefix(String commandPrefix) {
		EchoController.commandPrefix = commandPrefix;
	}
	
	

}
