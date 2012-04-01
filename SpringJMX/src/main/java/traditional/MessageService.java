package traditional;

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
		char[] chars = message.toCharArray();

		StringBuilder reversed = new StringBuilder();
		for (int i = chars.length; i > 0; i--) {
			reversed.append(chars[i - 1]);
		}

		return reversed.toString();
	}
}
