package br.com.dock.desafio2.services.exceptions;

public class AccountTypeNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AccountTypeNotFound(String message) {
		super(message);
	}

}
