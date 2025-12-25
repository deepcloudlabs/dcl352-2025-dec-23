package org.arch.services.engagement;

import generated.Messages.MsgEngageStatus;
import org.arch.services.Service;

public abstract interface EngagementServiceHandler extends Service {
	public default int getServiceId() {
		return 1;
	}
	public abstract void processMsgEngageStatus(MsgEngageStatus msg);
}
