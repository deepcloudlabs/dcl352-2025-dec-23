package com.example.hr.domain;

import com.example.ddd.ValueObject;

@ValueObject
public record RaiseRate(double percentage) {

	public double multiply(double value) {
		return (1.0+value/100.0) * value;
	}

}
