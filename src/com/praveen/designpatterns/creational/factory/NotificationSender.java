package com.praveen.designpatterns.creational.factory;

public class NotificationSender {

	public static void main(String[] args) {
		NotificationExecutorFactory.getNotificationExecutor("Email").executeNotification();
		NotificationExecutorFactory.getNotificationExecutor("SMS").executeNotification();
		NotificationExecutorFactory.getNotificationExecutor("FTP").executeNotification();
	}

}
