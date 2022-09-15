package com.employee.exception;

public class EmployeeDAOException extends Exception{
	
	private static final long serialVersionUID = 3171695136379460155L;

	public EmployeeDAOException() {
		super("Employee DAO Exception");
	}
	
	public EmployeeDAOException(String exception) {
		super(exception);
	}
}
