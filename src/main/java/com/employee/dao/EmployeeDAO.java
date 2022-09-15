package com.employee.dao;

import java.util.List;
import java.util.Optional;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeDAOException;

public interface EmployeeDAO {
	
	public List<Employee> getEmployee()throws EmployeeDAOException;
	public Optional<Employee> getEmployee(Integer id)throws EmployeeDAOException;
	public Employee saveEmployee(Employee employee)throws EmployeeDAOException;
	public Employee updateEmployee(Employee employee)throws EmployeeDAOException;
	public void deleteEmployee(Integer id)throws EmployeeDAOException;

}
