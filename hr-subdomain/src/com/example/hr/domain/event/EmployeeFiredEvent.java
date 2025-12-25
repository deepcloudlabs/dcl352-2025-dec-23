package com.example.hr.domain.event;

import com.example.hr.domain.TcKimlikNo;

public final class EmployeeFiredEvent extends HrEvent {

	public EmployeeFiredEvent(TcKimlikNo identity) {
		super(HrEventType.EMPLOYEE_FIRED, identity);
	}

}
