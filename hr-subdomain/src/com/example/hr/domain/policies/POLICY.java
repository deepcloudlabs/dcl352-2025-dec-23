package com.example.hr.domain.policies;

public enum POLICY {
	MINIMUM_WAGE(100,"Hiring is blocked by policy: salary below minimum wage.");
	
	private final int policyId;
	private final String message;
	
	private POLICY(int policyId, String message) {
		this.policyId = policyId;
		this.message = message;
	}
	public int getPolicyId() {
		return policyId;
	}
	public String getMessage() {
		return message;
	}
	
}
