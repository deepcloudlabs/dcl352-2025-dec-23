package com.example.engagement.application;

import com.example.engagement.service.EngagementHandler;

public interface EngageSupportable {
	void init();
	void register(EngagementHandler handler);
}
