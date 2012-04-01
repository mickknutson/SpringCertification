package notification;

import javax.management.Notification;

import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

public class MessagePublisher implements NotificationPublisherAware {

	private NotificationPublisher notificationPublisher;

	private int messageCount = 0;

	@Override
	public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
		this.notificationPublisher = notificationPublisher;
	}

	public void sendMessage(String message) {
		Notification notification = new Notification("message", this, messageCount++, System.currentTimeMillis(),
				message);
		notificationPublisher.sendNotification(notification);
	}

}
