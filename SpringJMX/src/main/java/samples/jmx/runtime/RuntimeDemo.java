package samples.jmx.runtime;

import java.io.IOException;

import javax.management.ObjectName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jmx.export.MBeanExportOperations;

/**
 * @author Rob Harrop
 */
public class RuntimeDemo {

	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"samples/jmx/runtime/runtimeDemo.xml");
		System.out.println("Started....");
		// grab the MBeanExportOperations - allows runtime registration
		MBeanExportOperations operations = ctx.getBean("exporter", MBeanExportOperations.class);
		for (int x = 1; x <= 10; x++) {
			System.out.println("Register bean: " + x);
			MessageService messageService = new MessageService();
			messageService.setMessage("Message: " + x);
			ObjectName generatedName = operations
					.registerManagedResource(messageService);
			System.out.println("Generated name: " + generatedName);
		}
		System.in.read();
	}
}
