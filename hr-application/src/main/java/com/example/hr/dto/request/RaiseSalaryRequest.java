package com.example.hr.dto.request;

import com.example.hr.domain.Department;
import com.example.hr.domain.RaiseRate;

public record RaiseSalaryRequest(Department department,RaiseRate rate) {

}
