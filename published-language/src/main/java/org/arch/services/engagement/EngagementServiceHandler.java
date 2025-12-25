package org.arch.services.engagement;

import generated.Messages.MsgEngageStatus;
import org.arch.services.Service;

public abstract class EngagementServiceHandler extends Service {
	public int serviceId = 1;
	public abstract void processMsgEngageStatus(MsgEngageStatus msg);
}
