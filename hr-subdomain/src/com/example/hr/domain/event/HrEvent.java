package com.example.hr.domain.event;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.example.helper.ddd.DomainEvent;
import com.example.hr.domain.TcKimlikNo;

@DomainEvent
public sealed abstract class HrEvent permits EmployeeFiredEvent, EmployeeHiredEvent, EmployeeSalaryRaisedEvent {
	private final String eventId = UUID.randomUUID().toString();
	private final ZonedDateTime eventDateTime = ZonedDateTime.now();
	private final EventType type;
	private final TcKimlikNo identity;

	public HrEvent(EventType type, TcKimlikNo identity) {
		this.type = type;
		this.identity = identity;
	}

	public String getEventId() {
		return eventId;
	}

	public EventType getType() {
		return type;
	}

	public TcKimlikNo getIdentity() {
		return identity;
	}

	public ZonedDateTime getEventDateTime() {
		return eventDateTime;
	}

}
