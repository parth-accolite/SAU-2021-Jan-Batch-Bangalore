package com.example.au.couchbasedemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/Employee")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }
    
    @GetMapping("/Employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable String id) {
        if (employeeRepository.existsById(id)) {
            return employeeRepository.findById(id);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/Employee/location/{location}")
    public Employee getEmployeeByLocation(@PathVariable String location) {
        return employeeRepository.findByLocation(location);
    }
    
    @GetMapping("/Employee/pinCode/{pinCode}")
    public Employee getEmployeeByPinCode(@PathVariable String pinCode) {
        return employeeRepository.findByPinCode(pinCode);
    }
//    @DeleteMapping("/Employee/pincode/{pincode}")
//    public List<Employee> deleteByAuthorAndTopic(@PathVariable String topic, @PathVariable String author) {
//        return employeeRepository.deleteBytopicAndAuthor(topic, author);
//    }
//    
//    @DeleteMapping("/Employee/{id}")
//    public void deleteById(@PathVariable String id) {
//        employeeRepository.deleteById(id);
//    }
    
	/*
	 * @PutMapping("/Employee/{idToBeUpdated}") public String updateEmployee(@PathVariable
	 * String idToBeUpdated, @RequestBody EmployeeUpdateRequest EmployeeUpdateRequest) {
	 * 
	 * Optional<Employee> mayBeEmployee = employeeRepository.findById(idToBeUpdated) .map(Employee
	 * –> employeeRepository .save(Employee .builder() .id(idToBeUpdated)
	 * .topic(EmployeeUpdateRequest.getTopic()) .tags(EmployeeUpdateRequest.getTags())
	 * .author(Employee.getAuthor()) .date(	.getDate()) .build()) ); if
	 * (mayBeEmployee.isPresent()) { return "Employee Updated"; } else { return
	 * "Employee does not exist"; } }
	 */
}