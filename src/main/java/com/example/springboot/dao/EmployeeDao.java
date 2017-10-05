package com.example.springboot.dao;

import java.util.List;

import com.example.springboot.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public void addEmployee(Employee employee);
	public int deleteEmployee(Long Id);
	public int updateEmployee(Employee employee, Long Id);
	public Employee getEmployee(Long Id);
	
}
