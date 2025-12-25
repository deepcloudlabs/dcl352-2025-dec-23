package org.arch.api;

public interface TrackSupport {
	void init();
	void registerToTrackInfo(ITrackInfoHandler handler);
	void unregisterToTrack(int id);
}
