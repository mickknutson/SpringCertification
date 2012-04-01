package com.baselogic.demos.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String open(Locale locale, Model model) {
		logger.info("PageController:: un-Secured location");
		
		return "open";
	}		
}
