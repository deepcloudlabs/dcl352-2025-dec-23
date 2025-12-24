package com.example.hr.domain;

import com.example.ddd.ValueObject;

@ValueObject
public record Country(String code) {
	public Country {
		if(!code.matches("[A-Z]{2}"))
			throw new IllegalArgumentException("%s is not a valid country code".formatted(code));
	}
}
