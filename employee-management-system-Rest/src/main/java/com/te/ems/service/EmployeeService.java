package com.te.ems.service;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.dto.RegisterationDTO;

public interface EmployeeService {

	EmployeeDTO getEmployee(String employeeId);

	String registerData(RegisterationDTO registerationDTO);

	String updateData(String employeeId, String userName);

	String deleteDetail(String employeeId);

}
