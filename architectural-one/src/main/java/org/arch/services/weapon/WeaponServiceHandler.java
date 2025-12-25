package org.arch.services.weapon;

import generated.Messages.MsgServoStatus;
import generated.Middleware.MdlwareServoCommand;
import org.arch.services.Service;

public abstract class WeaponServiceHandler extends Service {
	public int serviceId = 1;
	public abstract void processMsgServoStatus(MsgServoStatus msg);
	public abstract void processMdlwareServoCommand(MdlwareServoCommand servoCommand);
}
