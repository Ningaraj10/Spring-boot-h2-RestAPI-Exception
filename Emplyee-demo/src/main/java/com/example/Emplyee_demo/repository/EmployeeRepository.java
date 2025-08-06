package com.example.Emplyee_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Emplyee_demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
