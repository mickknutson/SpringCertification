package jsr160;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Jsr160Demo {

	public static void main(String[] args) throws IOException {
		new ClassPathXmlApplicationContext("jsr160/jsr160-config.xml");
		System.out.print("Ready.  Press Enter to Stop...");
		System.in.read();
	}

}
