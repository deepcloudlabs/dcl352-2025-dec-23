package com.example.hr.application.business;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.RaiseRate;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.domain.event.EmployeeFiredEvent;
import com.example.hr.domain.event.EmployeeHiredEvent;
import com.example.hr.domain.event.EmployeeSalaryRaisedEvent;
import com.example.hr.domain.event.HrEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

public class StandardHrApplication implements HrApplication {
	private final EmployeeRepository employeeRepository;
	private final EventPublisher<HrEvent> eventPublisher;

	public StandardHrApplication(EmployeeRepository employeeRepository, EventPublisher<HrEvent> eventPublisher) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Optional<Employee> findByIdentity(TcKimlikNo identity) {
		return employeeRepository.findById(identity);
	}

	@Override
	public Employee hire(Employee employee) {
		var identity = employee.getIdentityNo();
		if (employeeRepository.exists(identity))
			throw new IllegalArgumentException(
					"Employee with identity %s already exists!".formatted(identity.getValue()));
		Employee persistedEmployee = employeeRepository.persist(employee);
		var event = new EmployeeHiredEvent(employee);
		eventPublisher.publish(event);
		return persistedEmployee;
	}

	@Override
	public Employee fireEmployee(TcKimlikNo identity) {
		if (!employeeRepository.exists(identity))
			throw new IllegalArgumentException(
					"Employee with identity %s does not exists!".formatted(identity.getValue()));
		var employee = employeeRepository.remove(identity)
				.orElseThrow(() -> new IllegalArgumentException("Cannot fire employee"));
		var event = new EmployeeFiredEvent(employee.getIdentityNo());
		eventPublisher.publish(event);
		return employee;
	}

	@Override
	public List<Employee> raiseSalary(Department department, RaiseRate rate) {
		Consumer<Employee> raiseSalary = employee -> employee.raiseSalary(rate);
		Consumer<Employee> publishEvent = employee -> {
			var event = new EmployeeSalaryRaisedEvent(employee.getIdentityNo(), rate, employee.getSalary());
			eventPublisher.publish(event);
		};

		var employees = employeeRepository.findByDepartment(department);

		employees.stream().forEach(raiseSalary.andThen(employeeRepository::save).andThen(publishEvent));
		return employees;
	}

}
