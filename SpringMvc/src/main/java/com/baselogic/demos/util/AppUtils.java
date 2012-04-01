package com.baselogic.demos.util;

import java.io.*;

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

}
