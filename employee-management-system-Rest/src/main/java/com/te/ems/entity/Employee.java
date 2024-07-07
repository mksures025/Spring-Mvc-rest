package com.te.ems.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
@Entity
public class Employee {
    @Id
	private String employeeId;
	private String employeeDOJ;
	private String employeeName;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User userCredential;
	
}
