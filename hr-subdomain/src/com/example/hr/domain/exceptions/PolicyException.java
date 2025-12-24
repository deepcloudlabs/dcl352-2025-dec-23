package com.example.hr.domain.exceptions;

import com.example.hr.domain.policies.POLICY;

@SuppressWarnings("serial")
public class PolicyException extends RuntimeException {
	private final POLICY policy;

	public PolicyException(POLICY policy) {
		this.policy = policy;
	}

	public POLICY getPolicy() {
		return policy;
	}

}
