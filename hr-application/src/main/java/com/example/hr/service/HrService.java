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
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public EmployeeResponse fireEmployee(String identity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<EmployeeResponse> raiseSalary(RaiseSalaryRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public PhotoResponse findEmployeePhotoByIdentity(String identity) {
		var employee = hrApplication.findByIdentity(new TcKimlikNo(identity))
				.orElseThrow(() -> new IllegalArgumentException("Cannot find employee %d".formatted(identity)));		
		return new PhotoResponse(employee.getPhoto().toBase64());
	}
	
}
