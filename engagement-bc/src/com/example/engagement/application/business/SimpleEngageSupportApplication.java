package com.example.engagement.application.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.engagement.application.EngageSupportable;
import com.example.engagement.service.EngagementHandler;
import com.example.helper.hexagonal.Application;

@Application(port = EngageSupportable.class)
public class SimpleEngageSupportApplication implements EngageSupportable {
	private static List<EngagementHandler> engagementHandlers;

	@Override
	public void init() {
		engagementHandlers = Collections.synchronizedList(new ArrayList<>());
	}

	@Override
	public void register(EngagementHandler handler) {
		engagementHandlers.add(handler);
	}

	public List<EngagementHandler> getEngagementHandlers() {
		return List.copyOf(engagementHandlers);
	}
}
