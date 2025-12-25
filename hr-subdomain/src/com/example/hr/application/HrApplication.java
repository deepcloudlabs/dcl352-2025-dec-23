package com.example.hr.application;

import java.util.List;
import java.util.Optional;

import com.example.helper.hexagonal.Port;
import com.example.helper.hexagonal.PortType;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.RaiseRate;
import com.example.hr.domain.TcKimlikNo;

@Port(PortType.DRIVING)
public interface HrApplication {
	Optional<Employee> findByIdentity(TcKimlikNo identity);
	Employee hire(Employee employee);
	Employee fireEmployee(TcKimlikNo identity);
	List<Employee> raiseSalary(Department department,RaiseRate rate);
}
