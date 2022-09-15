package com.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Optional<Employee> findByUserId(Integer id);
	public void deleteByUserId(Integer id);
}
