package com.baselogic.demo.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.baselogic.demo.util.AppUtils;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String open(Locale locale, Model model) {
		logger.info("PageController:: un-Secured location");
		
		return "open";
	}
	
	@RequestMapping(value = "/secured", method = RequestMethod.GET)
	public String secured(Model model) {
		logger.info("PageController:: Secured location");
		
		return "secured";
	}
	
	@RequestMapping(value = "/secured/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		logger.info("PageController:: Secured Admin location");
		
		return "admin";
	}

	@RequestMapping(value = "/echo/{message}", method = RequestMethod.GET)
	public String echo(@PathVariable String message, Model model) {
		logger.info("PageController:: echo {}", message);
		
		model.addAttribute("message", message);
		
		return "echo";
	}

	@RequestMapping(value = "/fooJson", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> fooJson() {
		String json = "{\"level\" : \"INFO\", \"thread\" : \"main\", \"applicationName\" : \"DEMO\", \"eventType\" : \"Development\"}";
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>(json, responseHeaders,
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/images/{fileName}", method = RequestMethod.GET, produces = "image/jpeg")
	@ResponseBody
	public ResponseEntity<byte[]> getImage(@PathVariable String fileName, 
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		String imageRoot = "/resources";
		String imageFile = "/BLiNCLogo_5x5_300dpi.jpg";
		
		String imageLoc = request.getSession().getServletContext().getRealPath(imageRoot) + imageFile;

		File file = new File(imageLoc);

		byte[] image = AppUtils.findImage(file);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.IMAGE_JPEG);
	    responseHeaders.setContentLength(image.length);
		return new ResponseEntity<byte[]>(image, responseHeaders,
				HttpStatus.CREATED);
	}
	
	
}
