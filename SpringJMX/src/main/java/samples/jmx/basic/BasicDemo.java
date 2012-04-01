package samples.jmx.basic;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicDemo {

	public static void main(String[] args) throws IOException {
		new ClassPathXmlApplicationContext(
                "samples/jmx/basic/basicDemo.xml");
		System.out.println("Started....");
		System.in.read();
	}

}
