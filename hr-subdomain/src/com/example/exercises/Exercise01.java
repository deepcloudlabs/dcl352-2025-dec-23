package com.example.exercises;

import com.example.hr.domain.ContractType;

@SuppressWarnings("deprecation")
public class Exercise01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Integer value = new Integer(42);
		Integer anotherValue = Integer.valueOf(42);
		var intern = ContractType.valueOf("INTERN");
	}

}
