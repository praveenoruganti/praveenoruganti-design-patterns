package com.praveenoruganti.designpatterns.structural.bridge;

public class EmailMessage extends Message {

	EmailMessage(MessageSender messageSender) {
		super(messageSender);
	}

	@Override
	void send() {
		messageSender.sendMessage();
	}

}
