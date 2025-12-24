package com.example.hr.domain;

import com.example.helper.ddd.ValueObject;

@ValueObject
public enum ContractType {
	FULL_TIME_REMOTE, 
	FULL_TIME_HYBRID, 
	PART_TIME, INTERN, FREELANCE
}
