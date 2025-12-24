package com.example.hr.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.helper.hexagonal.Adapter;
import com.example.hr.document.EmployeeDocument;
import com.example.hr.document.repository.EmployeeDocumentRepository;
import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.repository.EmployeeRepository;

@Repository
@Adapter(adaptee = EmployeeDocumentRepository.class,target = EmployeeRepository.class)
public class EmployeeRepositoryMongoAdapter implements EmployeeRepository {
	private final EmployeeDocumentRepository employeeDocumentRepository;

	public EmployeeRepositoryMongoAdapter(EmployeeDocumentRepository employeeDocumentRepository) {
		this.employeeDocumentRepository = employeeDocumentRepository;
	}

	@Override
	public Optional<Employee> findById(TcKimlikNo identity) {
		return employeeDocumentRepository.findById(identity.getValue()).map(EmployeeRepositoryMongoAdapter::mapEmployeeDocumentToEmployee);
	}

	@Override
	public boolean exists(TcKimlikNo identity) {
		return employeeDocumentRepository.existsById(identity.getValue());
	}

	@Override
	@Transactional
	public Employee persist(Employee employee) {
		return mapEmployeeDocumentToEmployee(employeeDocumentRepository.insert(mapEmployeeToEmployeeDocument(employee)));
	}


	@Override
	@Transactional
	public Optional<Employee> remove(TcKimlikNo identity) {
		var document = employeeDocumentRepository.findById(identity.getValue());
		if (document.isEmpty()) return Optional.empty();
		document.ifPresent(employeeDocumentRepository::delete);
		return document.map(EmployeeRepositoryMongoAdapter::mapEmployeeDocumentToEmployee);
	}

	@Override
	public List<Employee> findByDepartment(Department department) {
		return employeeDocumentRepository.findAllByDepartments(department).stream().map(EmployeeRepositoryMongoAdapter::mapEmployeeDocumentToEmployee).toList();
	}

	@Override
	public Employee save(Employee employee) {
		return mapEmployeeDocumentToEmployee(employeeDocumentRepository.save(mapEmployeeToEmployeeDocument(employee)));
	}

	public static Employee mapEmployeeDocumentToEmployee(EmployeeDocument document) {
		return new Employee.Builder()
				           .identityNo(document.getIdentity())
				           .fullName(document.getFirstName(), document.getLastName())
				           .departments(document.getDepartments().stream().map(Department::name).toList().toArray(new String[0]))
				           .birthYear(document.getBirthYear())
				           .photo(document.getPhoto())
				           .contractType(document.getContractType().name())
				           .payment(document.getIban(), document.getCurrency().name())
				           .salary(document.getSalary(), document.getCurrency().name())
				           .hire();
	}
	
	public static EmployeeDocument mapEmployeeToEmployeeDocument(Employee employee) {
		var document = new EmployeeDocument();
		document.setIdentity(employee.getIdentityNo().getValue());
		document.setFirstName(employee.getFullName().getFirstName());
		document.setLastName(employee.getFullName().getLastName());
		document.setBirthYear(employee.getBirthYear().value());
		document.setContractType(employee.getContractType());
		document.setIban(employee.getPayment().iban().value());
		document.setCountryCode(employee.getPayment().country().code());
		document.setSalary(employee.getSalary().value());
		document.setCurrency(employee.getSalary().currency());
		document.setDepartments(employee.getDepartments().getValues());
		document.setPhoto(employee.getPhoto().toBase64());
		return document;
	}
	

}
