package com.example.engagement.service.business;

import com.example.engagement.domain.TrackId;
import com.example.engagement.service.EngagementHandler;

public class StandardEngagementHandler implements EngagementHandler {
	private TrackId trackId;

	@Override
	public void handle(TrackId id) {
		trackId = id;
		System.err.println("Handleing track...%s".formatted(trackId));
	}

	@Override
	public void cancel() {
		System.err.println("Cancelling tracking...%s".formatted(trackId));
	}

}
