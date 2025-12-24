package com.example.hr.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.example.hr.domain.ContractType;
import com.example.hr.domain.Department;
import com.example.hr.domain.FiatCurrency;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "employeees")
public class EmployeeDocument {
	@Id
	private String identity;
	@Field("fname")
	private String firstName;
	@Field("lname")
	private String lastName;
	private List<Department> departments;
	@Field("byear")
	@Indexed
	private int birthYear;
	private ContractType contractType;
	@Indexed(unique = true)
	@NotBlank
	private String iban;
	private String countryCode;
	private double salary;
	private FiatCurrency currency;
	private String photo;

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public ContractType getContractType() {
		return contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public FiatCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(FiatCurrency currency) {
		this.currency = currency;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "EmployeeDocument [identity=" + identity + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", departments=" + departments + ", birthYear=" + birthYear + ", contractType=" + contractType
				+ ", iban=" + iban + ", countryCode=" + countryCode + ", salary=" + salary + ", currency=" + currency
				+ "]";
	}

}
