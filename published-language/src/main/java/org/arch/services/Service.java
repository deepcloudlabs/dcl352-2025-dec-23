package org.arch.services;

import generated.util.MdlwareReporter;
import generated.util.MessageSender;

public abstract class Service {
	public MessageSender msgSender = MessageSender.getInstance();
	public MdlwareReporter mdlwareReporter = MdlwareReporter.getInstance();
	public abstract void onActive();
}
