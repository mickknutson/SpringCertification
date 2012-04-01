package notification;

import javax.management.Notification;
import javax.management.NotificationListener;

public class MessageReceiver implements NotificationListener {

	private int messageCount = 0;

	public int getMessageCount() {
		return messageCount;
	}

	@Override
	public void handleNotification(Notification notification, Object handback) {
		messageCount++;
		System.out.println(notification.getSequenceNumber() + ": " + notification.getTimeStamp() + ": "
				+ notification.getMessage());
	}
}
