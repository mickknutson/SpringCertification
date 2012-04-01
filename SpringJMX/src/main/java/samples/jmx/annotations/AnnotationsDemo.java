package samples.jmx.annotations;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemo {

	public static void main(String[] args) throws IOException {
		new ClassPathXmlApplicationContext(
				"samples/jmx/annotations/annotationsDemo.xml");
		System.out.println("Started...");
		System.in.read();
	}
}
