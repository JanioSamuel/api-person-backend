package com.api.pessoa.exception;

public class RequiredFieldsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequiredFieldsException(String message) throws Exception {
		super(message);
	}

}
