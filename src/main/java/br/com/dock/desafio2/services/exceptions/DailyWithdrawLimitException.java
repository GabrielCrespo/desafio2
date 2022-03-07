package br.com.dock.desafio2.services.exceptions;

public class DailyWithdrawLimitException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DailyWithdrawLimitException(String message) {
		super(message);
	}

}
