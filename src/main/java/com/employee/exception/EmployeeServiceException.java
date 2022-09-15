package com.employee.exception;

public class EmployeeServiceException extends Exception{

	private static final long serialVersionUID = 5096035073373745852L;

	public EmployeeServiceException() {
		super("Excepion in employee service");		
	}
	
	public EmployeeServiceException(String exception) {
		super(exception);		
	}
}
