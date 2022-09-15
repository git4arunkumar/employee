package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;
import com.employee.exception.EmployeeDAOException;
import com.employee.exception.EmployeeServiceException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	private String deleteMsg = "User Deleted Successfully";
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Employee> getEmployee()throws EmployeeServiceException{
		try {
			return employeeDAO.getEmployee();
		}catch(EmployeeDAOException exception) {
			throw new EmployeeServiceException("Exception in get employee list");
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{userId}")
	public Optional<Employee> getEmployee(@PathVariable("userId") Integer userId) throws EmployeeServiceException{
		try {
			System.out.println("id : " + userId);
			return employeeDAO.getEmployee(userId);
		}catch(EmployeeDAOException exception) {
			throw new EmployeeServiceException("Exception in get employee");
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Employee saveEmployee(@RequestBody Employee employee) throws EmployeeServiceException{
		try{
			return employeeDAO.saveEmployee(employee);
		}catch(EmployeeDAOException exception) {
			throw new EmployeeServiceException("Exception in save employee");
		}
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/{userId}")
	public Employee updateEmployee(@PathVariable("userId") Integer userId, @RequestBody Employee employee) throws EmployeeServiceException {
		try{
			return employeeDAO.updateEmployee(employee);
		}catch(EmployeeDAOException exception) {
			throw new EmployeeServiceException("Exception in update employee");
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{userId}")
	public String deleteEmployee(@PathVariable("userId") Integer userId) throws EmployeeServiceException {
		try{
			employeeDAO.deleteEmployee(userId);
			return deleteMsg;
		}catch(EmployeeDAOException exception) {
			throw new EmployeeServiceException("Exception in delete employee");
		}
	}
	
	
}