package com.example.hr.dto.response;

import java.util.List;

import com.example.hr.domain.ContractType;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.FiatCurrency;

public record EmployeeResponse(String identityNo, String firstName, String lastName, List<Department> departments,
		ContractType contractType, String iban, String countryCode, double salary, FiatCurrency currency,
		int birthYear) {

	public static EmployeeResponse from(Employee employee) {
		return new EmployeeResponse(
				employee.getIdentityNo().getValue(),
				employee.getFullName().getFirstName(),
				employee.getFullName().getLastName(),
				employee.getDepartments().getValues(),
				employee.getContractType(),
				employee.getPayment().iban().value(),
				employee.getPayment().country().code(),
				employee.getSalary().value(),
				employee.getSalary().currency(),
				employee.getBirthYear().value()
		);
	}

}
