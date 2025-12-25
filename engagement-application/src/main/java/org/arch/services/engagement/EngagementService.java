package org.arch.services.engagement;

import org.arch.api.EngageSupport;
import org.arch.api.IEngagementHandler;
import org.arch.api.ITrackInfoHandler;
import org.arch.api.TrackSupport;
import org.arch.model.TrackModel;
import org.springframework.stereotype.Service;

import generated.Messages.MsgEngageCommand;
import generated.Messages.MsgEngageStatus;
import generated.Messages.MsgTrack;
import generated.Messages.Type.MsgOffOnType;
import generated.Middleware.MdlwareEngageStatus;
import generated.util.MdlwareReporter;
import generated.util.MessageSender;

@Service
public class EngagementService implements EngagementServiceHandler {
	private final EngageSupport engSupport;
	private final TrackSupport trackSupport;
	private final MessageSender messageSender = MessageSender.getInstance();
	private final MdlwareReporter middlewareReporter = MdlwareReporter.getInstance();

	public EngagementService(EngageSupport engSupport, TrackSupport trackSupport) {
		this.engSupport = engSupport;
		this.trackSupport = trackSupport;
	}

	private int trackId;

	@Override
	public void onActive() {
		engSupport.init();
		trackSupport.init();

		registerToEngage();
	}

	private void registerToEngage() {
		engSupport.register(new IEngagementHandler() {

			@Override
			public void handle(int id) {
				// CheckPrecondition
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
			messageSender.send(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void sendStopEngagement() {
		try {
			MsgEngageCommand msg = new MsgEngageCommand();
			msg.setCommand(MsgOffOnType.OFF);
			messageSender.send(msg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 1 Hz Periodic while registered
	 * 
	 * @param id
	 */
	private void registerToTrack(int id) {
		try {
			trackSupport.registerToTrackInfo(new ITrackInfoHandler() {

				@Override
				public void handle(TrackModel track) {

					MsgTrack msg = new MsgTrack();
					msg.setxPos(track.getxPos());
					msg.setyPos(track.getyPos());
					msg.setzPos(track.getzPos());
					msg.setValidity(track.getValidity());
					messageSender.send(msg);
				}
			});
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
			engageStatus.setId(getServiceId());
			middlewareReporter.report(engageStatus);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
