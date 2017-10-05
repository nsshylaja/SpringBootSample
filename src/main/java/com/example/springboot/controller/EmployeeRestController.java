package com.example.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.Employee;
import com.example.springboot.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	final static Logger logger = Logger.getLogger(EmployeeRestController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.POST) 
	 	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) { 
	employeeService.addEmployee(employee); 
 		logger.debug("Added:: " + employee); 
 		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED); 
 	} 
	
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<Employee>> getAllEmployees() { 
 		List<Employee> employees = employeeService.getEmployees(); 
 		if (employees.isEmpty()) { 
 			logger.debug("Employees does not exists"); 
 			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT); 
		} 
 		logger.debug("Found " + employees.size() + " Employees"); 
 		logger.debug(employees); 
 		logger.debug(Arrays.toString(employees.toArray())); 
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK); 
 	} 
	
	@RequestMapping(value = "/{Id}", method = RequestMethod.DELETE) 
 	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long Id) { 
		int val = employeeService.deleteEmployee(Id); 
		if(val == 0){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Deleted:: " + Id); 
		
		return new ResponseEntity<Employee>(HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{Id}", method = RequestMethod.PUT) 
 	public ResponseEntity<Employee> updateEmployee(@PathVariable Long Id, @RequestBody Employee employee) { 
		int val = employeeService.updateEmployee(employee, Id); 
		logger.debug("Updated:: " + Id); 
		if(val == 0){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Employee>(HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{Id}", method = RequestMethod.GET) 
 	public ResponseEntity<Employee> getEmployee(@PathVariable Long Id) { 
		Employee employee = employeeService.getEmployee(Id); 
		if(employee == null){
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Selected:: " + Id); 
		return new ResponseEntity<Employee>(employee, HttpStatus.OK); 
	}

}
