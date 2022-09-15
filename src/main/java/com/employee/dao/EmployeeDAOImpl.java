package com.employee.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeDAOException;
import com.employee.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployee() throws EmployeeDAOException {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(Integer id) throws EmployeeDAOException {
		return employeeRepository.findByUserId(id);
	}

	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeDAOException {
		return employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeDAOException {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmployee(Integer id) throws EmployeeDAOException {
		employeeRepository.deleteByUserId(id);

	}

}
