package com.au.employee;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.au.employee.HibernateEveningApplication;
import com.au.employee.entity.Department;
import com.au.employee.entity.Employee;
import com.au.employee.entity.Project;
import com.au.employee.repository.EmployeeJPARepository;
import com.au.employee.repository.EmployeeRepository;

@SpringBootApplication
@Transactional
public class HibernateEveningApplication implements CommandLineRunner{

	@Resource
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeJPARepository employeeJPARepository;

	public static void main(String[] args) {
		System.out.println("Starting -------------------------");
		SpringApplication.run(HibernateEveningApplication.class, args);
	}

	public void run(String[] args) {
		System.out.println("Inside run ");
		Employee employee1 = new Employee();
		employee1.setName("PJ");
		employee1.setDesignation("SDE Intern");
		employee1.setAge(21);
		employee1.setSalary(20000);
		
		Employee employee2 = new Employee();
		employee2.setName("ABC");
		employee2.setDesignation("Manager");
		employee2.setAge(35);
		employee2.setSalary(100000);
		
		Department  department1 = new Department();
		department1.setLocation("Mumbai");
		department1.setName("Morgan Stanley");
		
		Department  department2 = new Department();
		department2.setLocation("Banglore");
		department2.setName("JusPay");
		
		Project project1 = new Project();		
		project1.setDetails("dummy project 1 details");
		project1.setTitle("Dummy 1");
		
		Project project2 = new Project();		
		project2.setDetails("dummy project 2 details");
		project2.setTitle("Dummy 2");
		
		employee1.setProject(project1);
		employee1.setDepartment(department1);
		
		employee2.setProject(project1);
		employee2.setDepartment(department1);
		
		Set<Employee> employeeSet = new HashSet<Employee>();
		employeeSet.add(employee1);
		employeeSet.add(employee2);
		project1.setEmployees(employeeSet);
		project1.setManager(employee2);
		
		department1.setManager(employee2);
		department1.setEmployees(employeeSet);
		
		employeeJPARepository.save(employee1);
		employeeJPARepository.save(employee2);
//		
//
//		employeeJPARepository.save(department1);
//		employeeJPARepository.save(department2);
//
//		employeeJPARepository.save(project1);
//		employeeJPARepository.save(project2);
		
		 
		 //employeeJPARepository.delete(employee);
		 //System.out.println("Data Removed in Database");
		 
		 // Find Employee by ID
		 Employee res = employeeRepository.getById(1);
		 System.out.println("Name of Employee" + res.getName());
		 System.out.println("Age of Employee" + res.getAge());
		 System.out.println("Salary of Employee" + res.getSalary());
		 System.out.println("Salary of Employee" + res.getDesignation());
		 System.out.println("Salary of Employee" + res.getDepartment().getName());
		 System.out.println("Salary of Employee" + res.getProject().getTitle());
		 
		 
//		 System.out.println(employeeJPARepository.findAll());
		
		
		
		
		
	}

}
