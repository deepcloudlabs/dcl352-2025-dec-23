package com.example.hr.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.request.RaiseSalaryRequest;
import com.example.hr.dto.response.EmployeeResponse;
import com.example.hr.dto.response.HireEmployeeResponse;
import com.example.hr.dto.response.PhotoResponse;

@Service
public class HrService {
	private final HrApplication hrApplication;
	
	public HrService(HrApplication hrApplication) {
		this.hrApplication = hrApplication;
	}
	
	@Cacheable
	public EmployeeResponse findEmployeeByIdentity(String identity) {
		var employee = hrApplication.findByIdentity(new TcKimlikNo(identity))
				.orElseThrow(() -> new IllegalArgumentException("Cannot find employee %d".formatted(identity)));		
		return EmployeeResponse.from(employee);
	}

	@Transactional
	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		return HireEmployeeResponse.from(hrApplication.hire(request.toEmployee()));
	}

	@Transactional
	public EmployeeResponse fireEmployee(String identity) {
		return EmployeeResponse.from(hrApplication.fireEmployee(new TcKimlikNo(identity)));
	}

	@Transactional
	public List<EmployeeResponse> raiseSalary(RaiseSalaryRequest request) {
		return hrApplication.raiseSalary(request.department(), request.rate()).stream().map(EmployeeResponse::from).toList();
	}

	public PhotoResponse findEmployeePhotoByIdentity(String identity) {
		var employee = hrApplication.findByIdentity(new TcKimlikNo(identity))
				.orElseThrow(() -> new IllegalArgumentException("Cannot find employee %d".formatted(identity)));		
		return new PhotoResponse(employee.getPhoto().toBase64());
	}
	
}
