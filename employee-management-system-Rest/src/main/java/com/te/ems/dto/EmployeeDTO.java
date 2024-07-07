package com.te.ems.dto;

import com.te.ems.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class EmployeeDTO {

	private String employeeId;
	private String username;
	private String employeeDOJ;
	private String employeeName;
	

}
