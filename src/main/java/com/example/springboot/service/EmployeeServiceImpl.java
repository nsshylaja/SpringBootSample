package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Transactional
	public List<Employee> getEmployees(){
		List<Employee> employeeList = employeeDao.getEmployees();
		
		return employeeList;
	}
	
	@Transactional
	public void addEmployee(Employee employee){
		employeeDao.addEmployee(employee);
	}
	
	@Transactional
	public int deleteEmployee(Long Id){
		int val = employeeDao.deleteEmployee(Id);
		return val;

	}
	
	@Transactional
	public int updateEmployee(Employee employee, Long Id){
		int val = employeeDao.updateEmployee(employee, Id);
		return val;
	}
	
	@Transactional
	public Employee getEmployee(Long Id){
		return employeeDao.getEmployee(Id);
	}
	
}
