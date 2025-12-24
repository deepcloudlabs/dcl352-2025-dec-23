package com.example.hr.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.request.RaiseSalaryRequest;
import com.example.hr.dto.response.EmployeeResponse;
import com.example.hr.dto.response.HireEmployeeResponse;
import com.example.hr.dto.response.PhotoResponse;
import com.example.hr.service.HrService;

@RestController
@RequestScope
@RequestMapping("/employees")
@Validated
@CrossOrigin
public class HrRestController {
	private final HrService hrService;
	
	public HrRestController(HrService hrService) {
		this.hrService = hrService;
	}

	@GetMapping("/{identity}")
	public EmployeeResponse findByIdentity(@PathVariable String identity){
		return hrService.findEmployeeByIdentity(identity);
	}
	
	@GetMapping("/{identity}/photo")
	public PhotoResponse getPhotoByIdentity(@PathVariable String identity){
		return hrService.findEmployeePhotoByIdentity(identity);
	}

	@PostMapping
	public HireEmployeeResponse hire(@RequestBody HireEmployeeRequest request) {
		return hrService.hireEmployee(request);
	}
	
	@DeleteMapping("/{identity}")
	public EmployeeResponse fire(@PathVariable String identity) {
		return hrService.fireEmployee(identity);

	}
	
	@PutMapping("/{identity}")
	public List<EmployeeResponse> raiseSalary(@RequestBody RaiseSalaryRequest request){
		return hrService.raiseSalary(request);
	}	
}
