package com.example.hr.domain.policies;

import com.example.helper.ddd.ValueObject;
import com.example.hr.domain.ContractType;
import com.example.hr.domain.Departments;
import com.example.hr.domain.Salary;

@ValueObject
public record EmployeeSalaryProposal(Salary salary, Departments departments, ContractType contractType) {
}
