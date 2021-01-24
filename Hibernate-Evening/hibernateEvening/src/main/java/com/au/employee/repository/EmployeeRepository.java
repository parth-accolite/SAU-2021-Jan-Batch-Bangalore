package com.au.employee.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.au.employee.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {
	@PersistenceContext
	EntityManager entityManager;
//	crud ops
	public void add(Employee employee) {
		entityManager.persist(employee);
	}
	
	public void remove(Employee employee) {
		entityManager.remove(employee);
	}
	
	public Employee update(Employee employee) {
		return entityManager.merge(employee);
	}
	
	public Employee getById(int id) {
		return entityManager.find(Employee.class,id);
	}
	
}
