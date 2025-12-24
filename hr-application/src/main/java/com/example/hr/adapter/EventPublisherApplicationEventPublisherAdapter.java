package com.example.hr.adapter;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.helper.hexagonal.Adapter;
import com.example.hr.domain.event.HrEvent;
import com.example.hr.infrastructure.EventPublisher;

@Service
@Adapter(adaptee = ApplicationEventPublisher.class, target = EventPublisher.class)
public class EventPublisherApplicationEventPublisherAdapter implements EventPublisher<HrEvent> {
	private final ApplicationEventPublisher eventPublisher;

	public EventPublisherApplicationEventPublisherAdapter(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Override
	public void publish(HrEvent event) {
		eventPublisher.publishEvent(event);
	}

}
