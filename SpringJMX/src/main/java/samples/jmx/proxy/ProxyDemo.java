package samples.jmx.proxy;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyDemo {

	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"samples/jmx/proxy/proxyDemo.xml");
		RuntimeInfo ri = ctx.getBean("runtime", RuntimeInfo.class);

		System.out.println("Boot Class Path: " + ri.getBootClassPath());
		System.out.println("Class Path: " + ri.getClassPath());
		System.out.println("VM Name: " + ri.getVmName());
		System.out.println("VM Vendor: " + ri.getVmVendor());
	}
}
