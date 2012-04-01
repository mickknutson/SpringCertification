package consumption;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumptionDemo {

	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("consumption/consumption-config.xml");
		MessageCapable mc = ctx.getBean("messageServiceClient", MessageCapable.class);
		System.out.println(mc.reverseMessage());
	}

}
