package org.arch.services.weapon;

import generated.Messages.MsgServoCommand;
import generated.Messages.MsgServoStatus;
import generated.Messages.Type.MsgOffOnType;
import generated.Middleware.MdlwareServoCommand;
import generated.Middleware.MdlwareServoStatus;
import generated.Middleware.Type.MdlwareOffOnType;

public class WeaponService extends WeaponServiceHandler  {

	@Override
	public void onActive() {
		// TODO Auto-generated method stub
	}

	@Override
	public void processMsgServoStatus(MsgServoStatus msg) {
		try {
			MdlwareServoStatus servoStatus = new MdlwareServoStatus();
			servoStatus.setId(serviceId);
			servoStatus.setStatus(msg.getStatus() == MsgOffOnType.ON ? MdlwareOffOnType.ON : MdlwareOffOnType.OFF);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void processMdlwareServoCommand(MdlwareServoCommand servoCommand) {
		try {
			if (servoCommand.getId() != serviceId)
				return;
			
			MsgServoCommand msg = new MsgServoCommand();
			msg.setCommand(servoCommand.getCommand() == MdlwareOffOnType.ON ? MsgOffOnType.ON : MsgOffOnType.OFF);
			msgSender.send(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
