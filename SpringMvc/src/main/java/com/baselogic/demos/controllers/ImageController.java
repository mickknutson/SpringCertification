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
