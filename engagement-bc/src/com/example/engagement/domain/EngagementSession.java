package com.example.engagement.domain;

import java.util.UUID;

import com.example.helper.ddd.Entity;

@Entity(id = "sessionId", aggregate = true)
public class EngagementSession {
	private SessionId sessionId;
	private TrackingId trackingId;
	private EngagementStatus status;
	
	public EngagementSession() {
	}

	public static class Builder {
		private SessionId sessionId;
		private TrackingId trackingId;
		private EngagementStatus status;
		public Builder() {
			this.sessionId = new SessionId(UUID.randomUUID().toString());
		}
		
		public Builder sessionId(String id) {
			this.sessionId = new SessionId(id);
			return this;
		}
		public Builder trackingId(String id) {
			this.trackingId = new TrackingId(id);
			return this;
		}
		public Builder status(String value) {
			this.status = EngagementStatus.valueOf(value);
			return this;
		}
		public EngagementSession build() {
			// Constraints
			// Validation Rules
			// Business Rules
			// Policies
			// Regulations
			// Invariants
			return new EngagementSession(this);
		}
	}
	// business/use-case -> method
}
