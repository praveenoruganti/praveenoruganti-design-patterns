package com.praveenoruganti.designpatterns.structural.bridge;

public class TextMessageSender implements MessageSender {

	@Override
	public void sendMessage() {
		System.out.println("Text Message Sent");
	}

}
