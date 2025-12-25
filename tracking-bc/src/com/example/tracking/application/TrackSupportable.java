package com.example.tracking.application;

import java.util.List;

import com.example.tracking.service.TrackInfoHandler;

public interface TrackSupportable {
	void init();
	void registerToTrackInfo(TrackInfoHandler handler);
	void unregisterToTrack(int id);
	List<TrackInfoHandler> getHandlers();
}
