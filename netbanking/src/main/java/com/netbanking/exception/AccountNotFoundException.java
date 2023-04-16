package com.netbanking.exception;

public class AccountNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6564288726410426493L;

	public AccountNotFoundException(String message) {
		super(message);
	}

	
}
