package com.baselogic.demos.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

import com.baselogic.demos.util.AppUtils;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
public class AppUtilsTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AppUtilsTest.class);

	@Test
	public void test() throws IOException {
		File file = new File("src/main/webapp/resources/BLiNCLogo_5x5_300dpi.jpg");
		
		assertThat(file.exists(), is(true));
		byte[] image = AppUtils.findImage(file);
		
		logger.info("file1 {}", file.getAbsoluteFile());
		logger.info("file2 {}", file.getCanonicalFile());
		logger.info("file3 {}", file.getCanonicalPath());

		assertThat(image.length, is(642644));
	}

	@Test
	public void testSpringEncoder_Admin() {
	    PasswordEncoder encoder = new Md5PasswordEncoder();
	    String hashedPass = encoder.encodePassword("admin", null);

	    assertThat(hashedPass, is("21232f297a57a5a743894a0e4a801fc3"));
	}

	@Test
	public void testSpringEncoder_Password() {
	    PasswordEncoder encoder = new Md5PasswordEncoder();
	    String hashedPass = encoder.encodePassword("password", null);

	    assertThat(hashedPass, is("5f4dcc3b5aa765d61d8327deb882cf99"));
	}

}
