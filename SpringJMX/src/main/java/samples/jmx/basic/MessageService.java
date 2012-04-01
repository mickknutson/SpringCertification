
package samples.jmx.basic;

public class MessageService {

	private String message = "Hello World!";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String reverseMessage() {
		char[] chars = this.message.toCharArray();
		StringBuffer buf = new StringBuffer();
		
		for (int i = chars.length - 1, x = 0; i >= 0; i--, x++) {
			buf.append(chars[i]);			
		}

		return buf.toString();		
	}	
}
