package br.com.dock.desafio2.services.exceptions;

public class BlockedAccountException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BlockedAccountException(String message) {
		super(message);
	}

}
