package com.te.ems.repository;

import java.util.Optional;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.entity.Employee;

public interface EmployeeRepository {

	Optional<Employee> getEmployeeID(String employeeId);

	String insertData(Employee employee);

	String updateData(String employeeId, String userName);

	String deleteDetail(String employeeId);
	

}
