package com.te.ems.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.ems.dto.EmployeeDTO;
import com.te.ems.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mysql01");
	EntityManager entityManager = entityManagerFactory.createEntityManager();


	@Override
	public String insertData(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee.getEmployeeId();
	}
	
	@Override
	public Optional<Employee> getEmployeeID(String employeeId) {

		return Optional.ofNullable(entityManager.find(Employee.class, employeeId));
	}

	@Override
	public String updateData(String employeeId, String employeeName) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Employee employee = entityManager.find(Employee.class, employeeId);
		
		if (employee.getEmployeeId().equals(employeeId)) {
			
			employee.setEmployeeName(employeeName);
			
			entityManager.persist(employee);
			entityTransaction.commit();
			return employee.getEmployeeName();
		}
		
		return null;
	}

	@Override
	public String deleteDetail(String employeeId) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Employee employee = entityManager.find(Employee.class, employeeId);
	if (employee.getEmployeeId().equals(employeeId)) {
		
			entityManager.remove(employee);
			entityTransaction.commit();
			return "Deleted";
		}
		
		return null;
	}


}
