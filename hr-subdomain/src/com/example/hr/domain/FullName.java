package com.example.hr.domain;

import java.util.Objects;

import com.example.ddd.ValueObject;

@ValueObject
public final class FullName {
	private final String firstName;
	private final String lastName;

	private FullName(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public static FullName valueOf(String firstName, String lastName) {
		Objects.requireNonNull(firstName);
		Objects.requireNonNull(lastName);
		if (firstName.isEmpty())
			throw new IllegalArgumentException("First Name cannot be empty.");
		if (lastName.isEmpty())
			throw new IllegalArgumentException("Last Name cannot be empty.");
		return new FullName(firstName, lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
