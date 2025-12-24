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
	
	public Salary(double value) {
		this(value,FiatCurrency.TL);
	}

	public Salary raise(RaiseRate rate) {
		// Constraints
		// Validation Rules
		// Business Rules
		// Policies
		// Regulations
		// Invariants
		return new Salary(rate.multiply(value),currency);
	}

	public boolean lessThan(Salary mimumWage) {
		return this.value < mimumWage.value();
	}
}
