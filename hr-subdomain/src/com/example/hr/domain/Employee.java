package com.example.hr.domain;

import java.util.List;

import com.example.ddd.Entity;

// Sub-domain : Analysis    --> Bounded-Context (BC) : Design -> Implementation
//               1          --> 1.**
// Real-world/Problem Space --> Solution Space
//            Domain Expert --> Ubiquitous Language is not a programming language
//                              Excel, Markdown, ... 
//                              Employee, TcKimlikNo, FullName, Department, ContractType, Photo, ... 
// Entity Class: 1) Persist -> Repository
//               2) identity: identityNo
@Entity(id="identityNo")
public class Employee {
	TcKimlikNo identityNo;
	FullName fullName;
	Departments departments;
	ContractType contractType;
	Photo photo;
	PaymentDetails payment;
	double salary;
	BirthYear birthYear;	
	Email email;
	PhoneNumber phoneNumber;
}
