package samples.jmx.runtime;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * @author Rick Evans
 */
@ManagedResource(description = "A Simple Message Service", objectName = "springsource:service=messageService")
public class MessageService {

	private String message = "Hello World!";

	@ManagedAttribute(description = "Gets the message")
	public String getMessage() {
		return message;
	}

	@ManagedAttribute(description = "Sets the message")
	public void setMessage(String message) {
		this.message = message;
	}

	@ManagedOperation(description = "Reverse the operation")
	public String reverseMessage() {
		char[] chars = this.message.toCharArray();

		StringBuffer buf = new StringBuffer();

		for (int i = chars.length - 1, x = 0; i >= 0; i--, x++) {
			buf.append(chars[i]);
		}

		return buf.toString();
	}

	public String upperCaseMessage() {
		return this.message.toUpperCase();
	}
}
