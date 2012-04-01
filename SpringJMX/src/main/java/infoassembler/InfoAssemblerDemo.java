package infoassembler;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InfoAssemblerDemo {

	public static void main(String[] args) throws IOException {
		new ClassPathXmlApplicationContext("infoassembler/infoassembler-config.xml");
		System.out.print("Ready.  Press Enter to Stop...");
		System.in.read();
	}

}
