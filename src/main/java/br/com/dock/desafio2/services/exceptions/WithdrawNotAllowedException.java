package br.com.dock.desafio2.services.exceptions;

public class WithdrawNotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public WithdrawNotAllowedException(String message) {
		super(message);
	}

}
