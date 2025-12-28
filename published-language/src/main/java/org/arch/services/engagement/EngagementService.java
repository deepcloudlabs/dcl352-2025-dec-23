package org.arch.services.engagement;

import generated.Messages.MsgEngageCommand;
import generated.Messages.MsgEngageStatus;
import generated.Messages.MsgTrack;
import generated.Messages.Type.MsgOffOnType;
import generated.Messages.Type.MsgStatusType;
import generated.Middleware.MdlwareEngageStatus;
import generated.Middleware.Type.MdlwareStatusType;

import org.arch.api.EngageSupport;
import org.arch.api.IEngagementHandler;
import org.arch.api.ITrackInfoHandler;
import org.arch.api.TrackSupport;
import org.arch.model.TrackModel;

public class EngagementService extends EngagementServiceHandler {
	private EngageSupport engSupport;
	private TrackSupport trackSupport;
	private int trackId;
	
	@Override
	public void onActive() {
		engSupport.init();
		trackSupport.init();
		
		registerToEngage();
	}

	private void registerToEngage()
	{
		engSupport.register(new IEngagementHandler() {
			
			@Override
			public void handle(int id) {
				//CheckPrecondition
				/**
				 * 
				 */
				trackId = id;
				
				registerToTrack(id);
				
				sendStartEngagement();
			}
			
			@Override
			public void cancel() {
				sendStopEngagement();
				unregisterToTrack(trackId);
			}
		});
	}
	
	private void sendStartEngagement() {
		try {
			MsgEngageCommand msg = new MsgEngageCommand();
			msg.setCommand(MsgOffOnType.ON);
			msgSender.send(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void sendStopEngagement() {
		try {
			MsgEngageCommand msg = new MsgEngageCommand();
			msg.setCommand(MsgOffOnType.OFF);
			msgSender.send(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 1 Hz Periodic while registered
	 * @param id
	 */
	private void registerToTrack(int id) {
		try {
			trackSupport.registerToTrackInfo(				
				(TrackModel track) -> {		
					MsgTrack msg = new MsgTrack();
					msg.setxPos(track.getxPos());
					msg.setyPos(track.getyPos());
					msg.setzPos(track.getzPos());
					msg.setValidity(track.getValidity());
					msgSender.send(msg);
				}
			);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void unregisterToTrack(int trackId) {
		try {
			trackSupport.unregisterToTrack(trackId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void processMsgEngageStatus(MsgEngageStatus msg) {
		try {
			MdlwareEngageStatus engageStatus = new MdlwareEngageStatus();
			engageStatus.setId(super.serviceId);
			engageStatus.setStatus(msg.getStatus()==MsgStatusType.IN_PROGRESS ? MdlwareStatusType.IN_PROGRESS : MdlwareStatusType.NOT_IN_PROGRESS);
			mdlwareReporter.report(engageStatus);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
