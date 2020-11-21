package com.praveen.designpatterns.creational.factory;

public class EmailNotificationExecutor implements NotificationExecutor {

	@Override
	public void executeNotification() {
		System.out.println("Email notification sent");
	}

}
