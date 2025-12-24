package com.example.hr.domain;

import java.util.Base64;
import java.util.Objects;

import com.example.helper.ddd.ValueObject;

@ValueObject
public record Photo(byte[] values) {
	public Photo {
		Objects.requireNonNull(values);
	}

	public Photo(String base64Value) {
		this(Base64.getDecoder().decode(base64Value));
	}

	@Override
	public String toString() {
		return "Photo [values=%s]".formatted(toBase64());
	}

	public String toBase64() {
		return Base64.getEncoder().encodeToString(values);
	}

}
