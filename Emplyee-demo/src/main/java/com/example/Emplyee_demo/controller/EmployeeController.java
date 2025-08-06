package com.example.Emplyee_demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Emplyee_demo.model.Employee;
import com.example.Emplyee_demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		
		this.service=service;
	}
	
	
	  @GetMapping
	    public List<Employee> getAll() {
	        return service.getAll();
	    }

	    @GetMapping("/{id}")
	    public Employee getById(@PathVariable Long id) {
	        return service.getById(id);
	    }

	    @PostMapping
	    public Employee create(@RequestBody Employee employee) {
	        return service.create(employee);
	    }

	    @PutMapping("/{id}")
	    public Employee update(@PathVariable Long id,  @RequestBody Employee employee) {
	        return service.update(id, employee);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        service.delete(id);
	    }
}
