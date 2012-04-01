package com.baselogic.demos.controllers;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baselogic.demos.util.AppUtils;

@Controller
public class ImageController {

	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);	

	/**
	 * Call service from HTML:
	 * 
	 * <img src="/images/duke" />
	 * <img src="/images/starbucks" />
	 * <img src="/images/BLiNCLogo_5x5_300dpi" />
	 * 
	 * Supported Mime Types:
	 * http://en.wikipedia.org/wiki/Mime_type
	 * 
	 * @param fileName
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/images/{fileName}",
				    method = RequestMethod.GET, 
				    produces = "image/jpeg")
	@ResponseBody
	public ResponseEntity<byte[]> getImage(@PathVariable String fileName, 
										   HttpServletRequest request, 
										   HttpServletResponse response) {
		
		logger.info("getImage fileName: {}", fileName);
		
		String imageRoot = "/resources";
		String suffix = ".jpg";
		
		// Can get file/image from database
		
		String imageLoc = request.getSession().getServletContext().getRealPath(imageRoot) 
				+ "/"
				+ fileName
				+ suffix;

		File file = new File(imageLoc);

		byte[] image = AppUtils.findImage(file);

		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.setContentType(MediaType.IMAGE_JPEG);
		
	    responseHeaders.setContentLength(image.length);
	    
		return new ResponseEntity<byte[]>(image, 
									      responseHeaders,
				                          HttpStatus.CREATED);
	}
	
	
}
