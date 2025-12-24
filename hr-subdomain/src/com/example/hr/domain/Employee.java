package com.example.hr.domain;

import java.time.LocalDateTime;

import com.example.helper.ddd.Entity;
import com.example.hr.domain.exceptions.PolicyException;
import com.example.hr.domain.policies.EmployeeSalaryProposal;
import com.example.hr.domain.policies.POLICY;
import com.example.hr.domain.policies.SalarySpecification;

// Sub-domain : Analysis    --> Bounded-Context (BC) : Design --> Aggregate
//               1          --> 1.**                          --> 1..* 
// Real-world/Problem Space --> Solution Space
//            Domain Expert --> Ubiquitous Language is not a programming language
//                              Excel, Markdown, ... 
//                              Employee, TcKimlikNo, FullName, Department, ContractType, Photo, ... 
// Entity Class: 1) Persist -> Repository
//               2) identity: identityNo
@Entity(id = "identityNo", aggregate = true)
public class Employee {
	TcKimlikNo identityNo;
	FullName fullName;
	Departments departments;
	ContractType contractType;
	Photo photo;
	PaymentDetails payment;
	Salary salary;
	BirthYear birthYear;

	private Employee(Builder builder) {
		this.identityNo = builder.identityNo;
		this.fullName = builder.fullName;
		this.departments = builder.departments;
		this.contractType = builder.contractType;
		this.photo = builder.photo;
		this.payment = builder.payment;
		this.salary = builder.salary;
		this.birthYear = builder.birthYear;
	}

	public TcKimlikNo getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(TcKimlikNo identityNo) {
		this.identityNo = identityNo;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public PaymentDetails getPayment() {
		return payment;
	}

	public void setPayment(PaymentDetails payment) {
		this.payment = payment;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public BirthYear getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(BirthYear birthYear) {
		this.birthYear = birthYear;
	}

	public static class Builder {
		TcKimlikNo identityNo;
		FullName fullName;
		Departments departments;
		ContractType contractType;
		Photo photo;
		PaymentDetails payment;
		Salary salary;
		BirthYear birthYear;
		private SalarySpecification salarySpecification;

		public Builder() {
		}

		public Builder identityNo(String identity) {
			this.identityNo = new TcKimlikNo(identity);
			return this;
		}

		public Builder fullName(String firstName, String lastName) {
			this.fullName = FullName.valueOf(firstName, lastName);
			return this;
		}

		public Builder departments(String... departmentValues) {
			this.departments = Departments.of(departmentValues);
			return this;
		}

		public Builder contractType(String value) {
			this.contractType = ContractType.valueOf(value);
			return this;
		}

		public Builder photo(String values) {
			this.photo = new Photo(values);
			return this;
		}

		public Builder photo(byte[] values) {
			this.photo = new Photo(values);
			return this;
		}

		public Builder payment(String iban, String countryCode) {
			this.payment = new PaymentDetails(new Iban(iban), new Country(countryCode));
			return this;
		}

		public Builder birthYear(int value) {
			this.birthYear = new BirthYear(value);
			return this;
		}

		public Builder salary(double value) {
			this.salary = new Salary(value, FiatCurrency.TL);
			return this;
		}

		public Builder salary(double value, String currency) {
			this.salary = new Salary(value, FiatCurrency.valueOf(currency));
			return this;
		}

		public Builder salary(double value, FiatCurrency currency) {
			this.salary = new Salary(value, currency);
			return this;
		}

		public Employee hire() {
			// Constraints
			// Validation Rules
			// Business Rules
			// Policies
			// Regulations
			// Invariants
			var proposal = new EmployeeSalaryProposal(salary,departments,contractType);
			if (!salarySpecification.isSatifiedBy(proposal)) {
				throw new PolicyException(POLICY.MINIMUM_WAGE);
			}
			return new Employee(this);
		}
	}

	public void adjustSalary(Salary newSalary,LocalDateTime effectiveDate) {
		// Constraints
		// Validation Rules
		// Business Rules
		// Policies
		// Regulations
		// Invariants
		
	}
	
	public void updateBankAccount(Iban newIban) {
		// Constraints
		// Validation Rules
		// Business Rules
		// Policies
		// Regulations
		// Invariants
		
	}
	
	public void changeContractType(ContractType newContractType) {
		// Constraints
		// Validation Rules
		// Business Rules
		// Policies
		// Regulations
		// Invariants
		
	}

	public Employee raiseSalary(RaiseRate rate) {
		// Constraints
		// Validation Rules
		// Business Rules
		// Policies
		// Regulations
		// Invariants
		this.salary = this.salary.raise(rate);
		return this;
	}
}
