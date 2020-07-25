package com.praveenoruganti.designpatterns.creational.factory;

public class NoNotificationExecutor implements NotificationExecutor {
	private String notificationType;

	NoNotificationExecutor(String notificationType) {
		this.notificationType = notificationType;
	}
	@Override
	public void executeNotification() {
		System.out.println("Notification Implementation not defined for "+ notificationType);
	}

}
