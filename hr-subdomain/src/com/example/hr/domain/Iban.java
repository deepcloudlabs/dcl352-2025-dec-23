package com.example.hr.domain;

import com.example.helper.ddd.ValueObject;

@ValueObject
public record Iban(String value) {
	private static final long MAX = 999999999;
	private static final long MODULUS = 97;

	public Iban {
		if (!isValid(value))
			throw new IllegalArgumentException("%s is not a valid iban.".formatted(value));
	}

	private boolean isValid(String value) {
		if (value == null || value.length() < 5) {
			return false;
		}
		try {
			int modulusResult = calculateModulus(value);
			return (modulusResult == 1);
		} catch (Exception ex) {
			return false;
		}
	}

	private int calculateModulus(String code) {
		String reformattedCode = code.substring(4) + code.substring(0, 4);
		long total = 0;
		for (int i = 0; i < reformattedCode.length(); i++) {
			int charValue = Character.getNumericValue(reformattedCode.charAt(i));
			if (charValue < 0 || charValue > 35) {
				throw new IllegalArgumentException("Invalid Character[" + i + "] = '" + charValue + "'");
			}
			total = (charValue > 9 ? total * 100 : total * 10) + charValue;
			if (total > MAX) {
				total = (total % MODULUS);
			}
		}
		return (int) (total % MODULUS);
	}
}
