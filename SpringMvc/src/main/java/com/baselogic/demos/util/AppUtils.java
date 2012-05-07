package com.baselogic.demos.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

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
public final class AppUtils {

	public final static byte[] findImage(File file){

		// BLiNCLogo_5x5_300dpi.jpg
		ByteArrayOutputStream tmp = null;
		InputStream in = null;

		try{

			tmp = new ByteArrayOutputStream(16384); // Pick some appropriate size
			in = new FileInputStream(file);

		    // Transfer bytes from in to out
		    byte[] buf = new byte[512];

		    while (true) {
		        int len = in.read(buf);
		        if (len == -1) {
		            break;
		        }
		        tmp.write(buf, 0, len);
		    }

		    return tmp.toByteArray();
		} catch (IOException e){
			e.printStackTrace();
		} finally{
		    try {
		    	if(in != null){
		    		in.close();
		    	}
		    	if(tmp != null){
		    		tmp.close();
		    	}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return new byte[0];

	}

	public static String encode(String token) {
		PasswordEncoder encoder = new Md5PasswordEncoder();
		return encoder.encodePassword(token, null);
	}

}
