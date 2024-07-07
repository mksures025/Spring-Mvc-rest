package com.te.ems.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.dto.RegisterationDTO;
import com.te.ems.entity.Employee;
import com.te.ems.entity.User;
import com.te.ems.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;



	@Override
	public String registerData(RegisterationDTO registerationDTO) {
		
		Employee employee= Employee.builder()
		.employeeId(registerationDTO.getEmployeeId())
		.employeeName(registerationDTO.getEmployeeName())
		.employeeDOJ(registerationDTO.getEmployeeDOJ())
		.build();
		
		User user = User.builder()
		.userName(registerationDTO.getUserName())
		.password(registerationDTO.getPassword())
		.employee(employee).build();
		
		employee.setUserCredential(user);
		
		return employeeRepository.insertData(employee) ;
	}
	
	// this method fetch the data from database
	@Override
	public EmployeeDTO getEmployee(String employeeId) {

		Optional<Employee> employee = employeeRepository.getEmployeeID(employeeId);

		if (employee.isPresent()) {

			Employee employees = employee.get();

			return EmployeeDTO.builder()
					.employeeId(employeeId)
					.employeeDOJ(employees.getEmployeeDOJ())
					.employeeName(employees.getEmployeeName())
					.username(employees.getUserCredential().getUserName())
					.build();
		}

		return null;
	}

	@Override
	public String updateData(String employeeId, String employeeName) {
		
		String name=employeeRepository.updateData(employeeId,employeeName);
		
		
		return name;
	}

	@Override
	public String deleteDetail(String employeeId) {
		
		String delete=employeeRepository.deleteDetail(employeeId);
		
		return delete;
	}



}
