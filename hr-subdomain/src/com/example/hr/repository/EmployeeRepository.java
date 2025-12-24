package com.example.hr.repository;

import java.util.List;
import java.util.Optional;

import com.example.helper.ddd.Repository;
import com.example.helper.hexagonal.Port;
import com.example.helper.hexagonal.PortType;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

@Repository
@Port(PortType.DRIVEN)
public interface EmployeeRepository {

	Optional<Employee> findById(TcKimlikNo identity);

	boolean exists(TcKimlikNo identity);

	Employee persist(Employee employee);

	Optional<Employee> remove(TcKimlikNo identity);

	List<Employee> findByDepartment(Department department);

	Employee save(Employee employee);

}
