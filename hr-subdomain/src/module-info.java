import com.example.hr.application.HrApplication;
import com.example.hr.application.business.StandardHrApplication;

module com.example.hr {
	requires com.example.ddd;
	exports com.example.hr.domain;
	exports com.example.hr.domain.exceptions;
	exports com.example.hr.domain.policies;
	exports com.example.hr.application;
	provides HrApplication with StandardHrApplication;
}