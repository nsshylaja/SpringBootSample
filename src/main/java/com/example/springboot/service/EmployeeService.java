package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entity.*;

public interface EmployeeService {
	public List<Employee> getEmployees();
	public void addEmployee(Employee employee);
	public int deleteEmployee(Long Id);
	public int updateEmployee(Employee employee, Long Id);
	public Employee getEmployee(Long Id);

}
