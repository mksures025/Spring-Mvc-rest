package com.te.ems.dto;

import com.te.ems.entity.Employee;
import com.te.ems.entity.User;

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
@ToString
@Builder
public class RegisterationDTO {
	
	private String employeeId;
	private String employeeDOJ;
	private String employeeName;
	private String userName;
	private String password;

}
