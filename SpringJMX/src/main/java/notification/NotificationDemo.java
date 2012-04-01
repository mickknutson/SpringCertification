package notification;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NotificationDemo {

	public static void main(String[] args) throws IOException {
		new ClassPathXmlApplicationContext("notification/notification-config.xml");
		System.out.print("Ready.  Press Enter to Stop...");
		System.in.read();
	}

}
