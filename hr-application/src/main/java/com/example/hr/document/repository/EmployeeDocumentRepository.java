package com.example.hr.document.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Department;

public interface EmployeeDocumentRepository extends MongoRepository<EmployeeDocument,String>{

	List<EmployeeDocument> findAllByDepartments(Department department);
	List<EmployeeDocument> findAllByBirthYearBetween(int fromYear,int toYear);
	

}
