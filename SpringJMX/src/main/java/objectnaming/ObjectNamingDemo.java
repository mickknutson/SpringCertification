package objectnaming;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectNamingDemo {

	public static void main(String[] args) throws IOException {
		new ClassPathXmlApplicationContext("objectnaming/objectnaming-config.xml");
		System.out.print("Ready.  Press Enter to Stop...");
		System.in.read();
	}

}
