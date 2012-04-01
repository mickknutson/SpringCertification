
package samples.jmx.traditional;

/**
 * @author robh
 */
public interface MessageServiceMBean {

	String getMessage();

	void setMessage(String message);

	String reverseMessage();
}
