package com.example.hr.domain.policies;

public class SalarySpecification implements Specification<EmployeeSalaryProposal>{
	private MinimumWageSpecification minimumWageSpecification = new MinimumWageSpecification();
	
	@Override
	public boolean isSatifiedBy(EmployeeSalaryProposal proposal) {
		return switch(proposal.contractType()) {
			case FULL_TIME_HYBRID -> minimumWageSpecification.isSatifiedBy(proposal.salary()); 
			default -> true;				
		};
	}

}
