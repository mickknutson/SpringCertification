package samples.jmx.connector;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author robh
 */
public class ConnectorDemo  {

    public static void main(String[] args) throws IOException {
        String[] locations = new String[]{"samples/jmx/connector/connectorDemo.xml", "samples/jmx/basic/basicDemo.xml"};
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
        System.out.println("Starting...");
        System.in.read();
        ctx.destroy();
    }
}
