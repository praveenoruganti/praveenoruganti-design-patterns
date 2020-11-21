package com.praveen.designpatterns.creational.factory;

public class SMSNotificationExecutor implements NotificationExecutor {

	@Override
	public void executeNotification() {
		System.out.println("SMS notification sent.");
	}

}
