package com.praveen.designpatterns.structural.bridge;

public class MessageTest {

	public static void main(String args[]) {
		MessageSender txtmessageSender = new TextMessageSender();
		Message txtMessage= new TextMessage(txtmessageSender);
		txtMessage.send();

		MessageSender emailmessageSender = new EmailMessageSender();
		Message emailMessage= new EmailMessage(emailmessageSender);
		emailMessage.send();
	}

}
