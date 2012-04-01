
package samples.jmx.traditional;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

/**
 * @author robh
 */
public class TraditionalDemo {

	public static void main(String[] args) throws Exception {
		// create the service
		MessageService service = new MessageService();

		// create/lookup an MBeanServer
		MBeanServer server = MBeanServerFactory.createMBeanServer();

		// create an ObjectName for the JMX service
		ObjectName objectName = new ObjectName("springsource:service=messageService");

		// register the MBean
		server.registerMBean(service, objectName);
	}
}
