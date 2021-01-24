package com.au.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.au.employee.entity.Employee;

public interface EmployeeJPARepository extends CrudRepository<Employee,Integer> {
	public Employee findEmployeeByProject_Id(int id);
	public Employee findEmployeeByDepartment_Id(int id);

	
}
