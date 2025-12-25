package com.example.tracking.application.business;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.helper.hexagonal.Application;
import com.example.tracking.application.TrackSupportable;
import com.example.tracking.service.TrackInfoHandler;

@Application(port = TrackSupportable.class)
public class StandardTrackSupport implements TrackSupportable {

	private static final Map<Integer, TrackInfoHandler> handlers = new ConcurrentHashMap<>();
	private static final AtomicInteger counter = new AtomicInteger(1);

	@Override
	public void init() {
	}

	@Override
	public void registerToTrackInfo(TrackInfoHandler handler) {
		handlers.put(counter.getAndIncrement(), handler);
	}

	@Override
	public void unregisterToTrack(int id) {
		handlers.remove(id);
	}

	@Override
	public List<TrackInfoHandler> getHandlers() {
		return List.copyOf(handlers.values());
	}

}
