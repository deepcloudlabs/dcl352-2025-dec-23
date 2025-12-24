package com.example.hr.dto.request;

import java.util.List;

import com.example.hr.domain.ContractType;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.FiatCurrency;

public record HireEmployeeRequest(String identityNo, String firstName, String lastName, List<Department> departments,
		ContractType contractType, String iban, String countryCode, double salary, FiatCurrency currency,
		int birthYear,String photo) {
	
	public Employee toEmployee() {
		return new Employee.Builder()
		           .identityNo(this.identityNo())
		           .fullName(this.firstName(), this.lastName())
		           .departments(this.departments().stream().map(Department::name).toList().toArray(new String[0]))
		           .birthYear(this.birthYear())
		           .photo(this.photo())
		           .contractType(this.contractType().name())
		           .payment(this.iban(), this.countryCode())
		           .salary(this.salary(), this.currency().name())
		           .hire();
	}
}
