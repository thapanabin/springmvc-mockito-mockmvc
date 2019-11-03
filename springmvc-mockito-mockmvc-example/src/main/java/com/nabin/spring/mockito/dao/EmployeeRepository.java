package com.nabin.spring.mockito.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabin.spring.mockito.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
