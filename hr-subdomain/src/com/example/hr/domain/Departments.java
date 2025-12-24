package com.example.hr.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

import com.example.ddd.ValueObject;

// Immutable
@ValueObject
public final class Departments {
	private final List<Department> values;

	private Departments(List<Department> values) {
		this.values = values;
	}

	public List<Department> getValues() {
		return List.copyOf(values);
	}

	public static Departments of(String... values) {
		Objects.requireNonNull(values);
		return new Departments(Arrays.asList(values).stream().map(Department::valueOf).distinct().toList());
	}

	public static Departments of(Department... values) {
		Objects.requireNonNull(values);
		return new Departments(Arrays.asList(values).stream().distinct().toList());
	}

	public static Departments of(Set<Department> values) {
		Objects.requireNonNull(values);
		if (values.isEmpty())
			throw new IllegalArgumentException("Departments list cannot be empty");
		return new Departments(List.copyOf(values));
	}
	
	public Departments addDepartment(Department department) {
		// validation
		if (values.contains(department))
			throw new IllegalArgumentException("%s already exists in the list".formatted(department));
	    var newList = new ArrayList<>(values);
	    newList.add(department);
		return new Departments(newList);
	}

	public Departments removeDepartment(Department department) {
		// validation
		if (!values.contains(department))
			throw new IllegalArgumentException("%s already exists in the list".formatted(department));
		var newList = new ArrayList<>(values);
		newList.remove(department);
		Predicate<Department> equals = dept -> dept == department;
		return new Departments(values.stream().filter(equals.negate()).toList());
	}

}
