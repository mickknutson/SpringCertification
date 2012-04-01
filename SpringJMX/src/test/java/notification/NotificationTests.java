package notification;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/notification/notification-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class NotificationTests {

	@Autowired
	private MessagePublisher messagePublisher;

	@Autowired
	private MessageReceiver messageReceiver;

	@Test
	public void testNotification() {
		messagePublisher.sendMessage("test message");
		assertEquals(1, messageReceiver.getMessageCount());
	}

}
