package com.praveen.designpatterns.creational.factory;

public class NotificationExecutorFactory {
	public static NotificationExecutor getNotificationExecutor(String executorType) {

		switch (executorType) {
		case "Email":
			return new EmailNotificationExecutor();

		case "SMS":
			return new SMSNotificationExecutor();

		default:
			return new NoNotificationExecutor(executorType);

		}

	}
}
