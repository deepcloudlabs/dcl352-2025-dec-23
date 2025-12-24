package com.example.hr.domain;

import com.example.helper.ddd.ValueObject;

@ValueObject
public record RaiseRate(double percentage) {

	public double multiply(double value) {
		return (1.0+percentage/100.0) * value;
	}

}
