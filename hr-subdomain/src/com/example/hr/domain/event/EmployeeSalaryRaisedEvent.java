package com.example.hr.domain.event;

import com.example.hr.domain.RaiseRate;
import com.example.hr.domain.Salary;
import com.example.hr.domain.TcKimlikNo;

public final class EmployeeSalaryRaisedEvent extends HrEvent {

	private final RaiseRate rate;
	private final Salary raisedSalary;

	public EmployeeSalaryRaisedEvent(TcKimlikNo identity,RaiseRate rate,Salary raisedSalary) {
		super(HrEventType.EMPLOYEE_SALARY_RAISED, identity);
		this.rate = rate;
		this.raisedSalary = raisedSalary;
	}

	public RaiseRate getRate() {
		return rate;
	}

	public Salary getRaisedSalary() {
		return raisedSalary;
	}

}
