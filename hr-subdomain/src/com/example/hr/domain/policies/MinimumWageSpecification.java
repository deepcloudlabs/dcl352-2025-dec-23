package com.example.hr.domain.policies;

import com.example.hr.domain.Salary;

public class MinimumWageSpecification implements Specification<Salary> {

	private Salary MimumWage = new Salary(28_000);

	@Override
	public boolean isSatifiedBy(Salary salary) {
		return salary.lessThan(MimumWage );
	}
	
}
