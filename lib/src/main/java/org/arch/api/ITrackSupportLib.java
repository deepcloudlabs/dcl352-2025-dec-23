package org.arch.api;

public interface ITrackSupportLib {
	void init();
	void registerToTrackInfo(ITrackInfoHandler handler);
	void unregisterToTrack(int id);
}
