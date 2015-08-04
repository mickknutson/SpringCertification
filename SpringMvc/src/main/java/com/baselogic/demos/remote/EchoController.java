package com.baselogic.demos.remote;

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

		logger.info("commandPrefix: {}, serviceUrl: {}, command: {}", commandPrefix, serviceUrl);

		model.addAttribute("id", commandPrefix + ": " + serviceUrl + ": " + command );

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
