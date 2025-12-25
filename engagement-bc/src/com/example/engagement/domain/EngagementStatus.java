package com.example.engagement.domain;

import com.example.helper.ddd.ValueObject;

@ValueObject
public enum EngagementStatus {
	ACTIVE, INACTIVE, CANCELLED;
}
