package com.example.hr.domain.event;

import com.example.hr.domain.Employee;

public final class EmployeeHiredEvent extends HrEvent {

	private final Employee employee;

	public EmployeeHiredEvent(Employee employee) {
		var identity = employee.getIdentityNo();
		super(HrEventType.EMPLOYEE_HIRED, identity);
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

}
