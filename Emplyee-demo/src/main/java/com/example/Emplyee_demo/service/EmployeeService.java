package com.example.Emplyee_demo.service;

import java.util.List;


import com.example.Emplyee_demo.exception.ResourceNotFoundException;
import com.example.Emplyee_demo.model.Employee;
import com.example.Emplyee_demo.repository.EmployeeRepository;

public class EmployeeService {

	 
	    private EmployeeRepository repository;
	    
	    public EmployeeService(EmployeeRepository repository) {
	    	this.repository=repository;
	    }

	    public List<Employee> getAll() {
	        return repository.findAll();
	    }

	    public Employee getById(Long id) {
	        return repository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
	    }

	    public Employee create(Employee employee) {
	        return repository.save(employee);
	    }
	    
	    public Employee update(Long id, Employee employee) {
	        Employee existing = getById(id);
	        existing.setName(employee.getName());
	        existing.setEmail(employee.getEmail());
	        existing.setDepartment(employee.getDepartment());
	        return repository.save(existing);
	    }

	    public void delete(Long id) {
	        repository.deleteById(id);
	    }
}
