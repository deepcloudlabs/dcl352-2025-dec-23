package com.example.hr.service;

import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;

@Service
public class HrWebSocketService {
	private final HrApplication hrApplication;
	
	public HrWebSocketService(HrApplication hrApplication) {
		this.hrApplication = hrApplication;
	}

	public void handle(String command) {
		// Published Language
		//TODO: command(json) -> HireCommand/FireCommand/RaiseSalaryCommand -> hrApplication
	}

}
