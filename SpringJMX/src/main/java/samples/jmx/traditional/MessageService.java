
package samples.jmx.traditional;

/**
 * @author robh
 */
public class MessageService implements MessageServiceMBean {

	private String message = "Hello World!";

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String reverseMessage() {
		char[] chars = this.message.toCharArray();

		StringBuffer buf = new StringBuffer();
		
		for (int i = chars.length - 1, x = 0; i >= 0; i--, x++) {
			buf.append(chars[i]);			
		}

		return buf.toString();		
	}	
}
