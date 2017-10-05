package com.example.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@PersistenceContext
    private EntityManager entityManager;
	
    
	@Override
	public List<Employee> getEmployees(){
		logger.info("in EmployeeDaoImpl getEmployees");
		List <Employee> employeeList = entityManager.unwrap(Session.class).createQuery("from Employee").list();
	      return employeeList;
	}
	
	@Override
	public void addEmployee(Employee employee)  {
		 logger.info("in EmployeeDaoImpl addEmployee ");
		 entityManager.unwrap(Session.class).persist(employee);;
		 
	}
	
	@Override
	public int deleteEmployee(Long Id)  {
		 logger.info("in EmployeeDaoImpl deleteEmployee ");
		 Query query = entityManager.unwrap(Session.class).createQuery("delete from Employee e where e.Id ="+Id+"");
		 int val = query.executeUpdate();
		 return val; 
		}
	
	@Override
	public int updateEmployee(Employee employee, Long Id)  {
		 logger.info("in EmployeeDaoImpl updateEmployee ");
		 Query query = entityManager.unwrap(Session.class).createQuery("update Employee set firstname='"+employee.getfName()+"', lastname='"+employee.getlName()+"', email = '"+employee.getEmail()+"' where Id ="+Id+"");
		 int val = query.executeUpdate();
		 return val; 
	}
	
	@Override
	public Employee getEmployee(Long Id){
		return (Employee) entityManager.unwrap(Session.class).get(Employee.class, Id);
		
	}
	

}
