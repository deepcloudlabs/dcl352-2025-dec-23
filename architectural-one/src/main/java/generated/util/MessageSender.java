package generated.util;

import generated.Messages.IMsg;

public class MessageSender {
	
	private static MessageSender INSTANCE = new MessageSender();
	
	private MessageSender() {
		// TODO Auto-generated constructor stub
	}
	
	public static MessageSender getInstance() {
		return INSTANCE;
	}
	
	public void send(IMsg msg) {
		//send message
	}
}
