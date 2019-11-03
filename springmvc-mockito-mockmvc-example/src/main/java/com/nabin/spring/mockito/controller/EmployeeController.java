package com.nabin.spring.mockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nabin.spring.mockito.dao.EmployeeRepository;
import com.nabin.spring.mockito.model.Employee;
import com.nabin.spring.mockito.model.Response;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@PostMapping("/employees")
	public Response addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return new Response(employee.getId()+"inserted",Boolean.TRUE);
	}
	
	@GetMapping("/getEmployees")
	public Response getAllEmployees() {
		List<Employee>employees = employeeRepository.findAll();
		return new Response("records count: "+employees.size(),Boolean.TRUE);
		
	}
	
	

}
