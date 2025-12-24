package com.example.hr.domain;

import java.util.Objects;

import com.example.ddd.ValueObject;

@ValueObject
public record Salary(double value, FiatCurrency currency) {
	public Salary {
		Objects.requireNonNull(currency);
		if (value <= 0.0)
			throw new IllegalArgumentException("Salary cannot be zero or negative: %d".formatted(value));
	}
	
	public Salary raise(RaiseRate rate) {
		return new Salary(rate.multiply(value),currency);
	}
}
