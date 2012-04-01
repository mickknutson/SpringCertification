package traditional;

import java.io.IOException;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class TraditionalDemo {

	public static void main(String[] args) throws InstanceAlreadyExistsException, MBeanRegistrationException,
			NotCompliantMBeanException, MalformedObjectNameException, IOException {
		new TraditionalDemo().registerMessageService();
		System.out.print("Ready.  Press Enter to Stop...");
		System.in.read();
	}

	private void registerMessageService() throws MalformedObjectNameException, InstanceAlreadyExistsException,
			MBeanRegistrationException, NotCompliantMBeanException {
		MessageService messageService = new MessageService();
		ObjectName objectName = new ObjectName("service:name=messageService");
		MBeanServer mBeanServer = MBeanServerFactory.findMBeanServer(null).get(0);
		mBeanServer.registerMBean(messageService, objectName);
	}

}
