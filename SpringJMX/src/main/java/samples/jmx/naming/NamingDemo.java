package samples.jmx.naming;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NamingDemo {

	public static void main(String[] args) throws IOException {
		new ClassPathXmlApplicationContext(
				"samples/jmx/naming/namingDemo.xml");
		System.out.println("Started...");
		System.in.read();
	}
}
