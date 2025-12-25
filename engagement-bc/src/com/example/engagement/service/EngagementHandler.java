package com.example.engagement.service;

import com.example.engagement.domain.TrackId;

public interface EngagementHandler {
	void handle(TrackId id);
	void cancel();
}
